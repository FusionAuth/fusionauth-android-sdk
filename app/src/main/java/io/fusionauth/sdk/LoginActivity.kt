/*
 * Copyright 2015 The AppAuth for Android Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fusionauth.sdk

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import io.fusionauth.mobilesdk.AuthenticationConfiguration
import io.fusionauth.mobilesdk.AuthenticationManager
import kotlinx.coroutines.launch
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Demonstrates the usage of the AppAuth to authorize a user with an OAuth2 / OpenID Connect
 * provider. Based on the configuration provided in `res/raw/auth_config.json`, the code
 * contained here will:
 *
 * - Retrieve an OpenID Connect discovery document for the provider, or use a local static
 * configuration.
 * - Utilize dynamic client registration, if no static client id is specified.
 * - Initiate the authorization request using the built-in heuristics or a user-selected browser.
 *
 * _NOTE_: From a clean checkout of this project, the authorization service is not configured.
 * Edit `res/raw/auth_config.json` to provide the required configuration properties. See the
 * README.md in the app/ directory for configuration instructions, and the adjacent IDP-specific
 * instructions.
 */
class LoginActivity : AppCompatActivity() {

//    private var mAuthService: AuthorizationService? = null
//    private var mAuthStateManager: AuthStateManager? = null
//    private var mConfiguration: Configuration? = null

//    private val mClientId = AtomicReference<String>()

    //    private val mAuthRequest: AtomicReference<AuthorizationRequest?> = AtomicReference<AuthorizationRequest?>()
//    private val mAuthIntent: AtomicReference<CustomTabsIntent?> = AtomicReference<CustomTabsIntent?>()
    private var mAuthIntentLatch = CountDownLatch(1)
    private lateinit var mExecutor: ExecutorService


//    private val mBrowserMatcher: BrowserMatcher = AnyBrowserMatcher.INSTANCE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mExecutor = Executors.newSingleThreadExecutor()

        AuthenticationManager.initialize(
            AuthenticationConfiguration(
                clientId = "21e13847-4f30-4477-a2d9-33c3a80bd15a",
                fusionAuthUrl = "http://10.168.145.33:9011",
                allowUnsecureConnection = true
            )
        )

//        mAuthStateManager = AuthStateManager.getInstance(this)
//        mConfiguration = Configuration.getInstance(this)

        if (/*mAuthStateManager.getCurrent().isAuthorized()
            && !mConfiguration.hasConfigurationChanged()*/AuthenticationManager.isAuthenticated()
        ) {
            Log.i(TAG, "User is already authenticated, proceeding to token activity")
            startActivity(Intent(this, TokenActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_login)

        /*findViewById<View>(R.id.retry).setOnClickListener {
            mExecutor.submit { this.initializeAppAuth() }
        }*/
        findViewById<View>(R.id.start_auth).setOnClickListener {
            lifecycleScope.launch {
                Log.i(TAG, "Creating auth request for ")
                AuthenticationManager
                    .oAuth(this@LoginActivity)
                    .authorize(
                        PendingIntent.getActivity(
                            this@LoginActivity,
                            0,
                            Intent(this@LoginActivity, TokenActivity::class.java),
                            PendingIntent.FLAG_IMMUTABLE
                        )
                    )
            }
        }

//        if (!mConfiguration.isValid()) {
//            displayError(mConfiguration.getConfigurationError(), false)
//            return
//        }

        /*if (mConfiguration.hasConfigurationChanged()) {
            // discard any existing authorization state due to the change of configuration
            Log.i(TAG, "Configuration change detected, discarding old state")
            mAuthStateManager.replace(AuthState())
            mConfiguration.acceptConfiguration()
        }*/

        if (intent.getBooleanExtra(EXTRA_FAILED, false)) {
            displayAuthCancelled()
        }

//        displayLoading("Initializing")
        displayAuthOptions()
//        mExecutor.submit { this.initializeAppAuth() }
    }

    override fun onStart() {
        super.onStart()
        if (mExecutor.isShutdown) {
            mExecutor = Executors.newSingleThreadExecutor()
        }
    }

    override fun onStop() {
        super.onStop()
        mExecutor.shutdownNow()
    }

    override fun onDestroy() {
        super.onDestroy()

//        if (mAuthService != null) {
//            mAuthService.dispose()
//        }
        AuthenticationManager.dispose()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        displayAuthOptions()
        if (resultCode == Activity.RESULT_CANCELED) {
            displayAuthCancelled()
        } else {
            val intent = Intent(this, TokenActivity::class.java)
            intent.putExtras(data!!.extras!!)
            startActivity(intent)
        }
    }

    @MainThread
    fun startAuth() {
        displayLoading("Making authorization request")

        // WrongThread inference is incorrect for lambdas
        // noinspection WrongThread
        mExecutor.submit { this.doAuth() }
    }

    /**
     * Initializes the authorization service configuration if necessary, either from the local
     * static values or by retrieving an OpenID discovery document.
     */
    /*@WorkerThread
    private fun initializeAppAuth() {
        Log.i(TAG, "Initializing AppAuth")
        recreateAuthorizationService()

        if (mAuthStateManager.getCurrent().getAuthorizationServiceConfiguration() != null) {
            // configuration is already created, skip to client initialization
            Log.i(TAG, "auth config already established")
            initializeClient()
            return
        }

        // if we are not using discovery, build the authorization service configuration directly
        // from the static configuration values.
        if (mConfiguration.getDiscoveryUri() == null) {
            Log.i(TAG, "Creating auth config from res/raw/auth_config.json")
            val config: AuthorizationServiceConfiguration = AuthorizationServiceConfiguration(
                mConfiguration.getAuthEndpointUri(),
                mConfiguration.getTokenEndpointUri(),
                mConfiguration.getRegistrationEndpointUri(),
                mConfiguration.getEndSessionEndpoint()
            )

            mAuthStateManager.replace(AuthState(config))
            initializeClient()
            return
        }

        // WrongThread inference is incorrect for lambdas
        // noinspection WrongThread
        runOnUiThread(Runnable { displayLoading("Retrieving discovery document") })
        Log.i(TAG, "Retrieving OpenID discovery doc")
        AuthorizationServiceConfiguration.fetchFromUrl(
            mConfiguration.getDiscoveryUri(),
            { config: AuthorizationServiceConfiguration?, ex: AuthorizationException ->
                this.handleConfigurationRetrievalResult(
                    config,
                    ex
                )
            },
            mConfiguration.getConnectionBuilder()
        )
    }*/

    /*@MainThread
    private fun handleConfigurationRetrievalResult(
        config: AuthorizationServiceConfiguration?,
        ex: AuthorizationException
    ) {
        if (config == null) {
            Log.i(TAG, "Failed to retrieve discovery document", ex)
            displayError("Failed to retrieve discovery document: " + ex.getMessage(), true)
            return
        }

        Log.i(TAG, "Discovery document retrieved")
        mAuthStateManager.replace(AuthState(config))
        mExecutor.submit { this.initializeClient() }
    }*/

    /**
     * Initiates a dynamic registration request if a client ID is not provided by the static
     * configuration.
     */
    /*@WorkerThread
    private fun initializeClient() {
        if (mConfiguration.getClientId() != null) {
            Log.i(TAG, "Using static client ID: " + mConfiguration.getClientId())
            // use a statically configured client ID
            mClientId.set(mConfiguration.getClientId())
            runOnUiThread(Runnable { this.initializeAuthRequest() })
            return
        }

        val lastResponse: RegistrationResponse =
            mAuthStateManager.getCurrent().getLastRegistrationResponse()
        if (lastResponse != null) {
            Log.i(TAG, "Using dynamic client ID: " + lastResponse.clientId)
            // already dynamically registered a client ID
            mClientId.set(lastResponse.clientId)
            runOnUiThread(Runnable { this.initializeAuthRequest() })
            return
        }

        // WrongThread inference is incorrect for lambdas
        // noinspection WrongThread
        runOnUiThread(Runnable { displayLoading("Dynamically registering client") })
        Log.i(TAG, "Dynamically registering client")

        val registrationRequest: RegistrationRequest = Builder(
            mAuthStateManager.getCurrent().getAuthorizationServiceConfiguration(),
            listOf(mConfiguration.getRedirectUri())
        )
            .setTokenEndpointAuthenticationMethod(ClientSecretBasic.NAME)
            .build()

        mAuthService.performRegistrationRequest(
            registrationRequest
        ) { response: RegistrationResponse?, ex: AuthorizationException ->
            this.handleRegistrationResponse(
                response,
                ex
            )
        }
    }*/

    /*@MainThread
    private fun handleRegistrationResponse(
        response: RegistrationResponse?,
        ex: AuthorizationException
    ) {
        mAuthStateManager.updateAfterRegistration(response, ex)
        if (response == null) {
            Log.i(TAG, "Failed to dynamically register client", ex)
            displayErrorLater("Failed to register client: " + ex.getMessage(), true)
            return
        }

        Log.i(TAG, "Dynamically registered client: " + response.clientId)
        mClientId.set(response.clientId)
        initializeAuthRequest()
    }*/

    /**
     * Performs the authorization request, using the browser selected in the spinner
     */
    @WorkerThread
    private fun doAuth() {
        try {
            mAuthIntentLatch.await()
        } catch (ex: InterruptedException) {
            Log.w(TAG, "Interrupted while waiting for auth intent")
        }

        lifecycleScope.launch {
            Log.i(TAG, "Creating auth request for ")
            AuthenticationManager
                .oAuth(this@LoginActivity)
                .authorize(
                    PendingIntent.getActivity(
                        this@LoginActivity,
                        RC_AUTH,
                        Intent(this@LoginActivity, TokenActivity::class.java),
                        PendingIntent.FLAG_IMMUTABLE
                    )
                )
        }.start()
    }

    /*private fun recreateAuthorizationService() {
        if (mAuthService != null) {
            Log.i(TAG, "Discarding existing AuthService instance")
            mAuthService.dispose()
        }
        mAuthService = createAuthorizationService()
        mAuthRequest.set(null)
        mAuthIntent.set(null)
    }*/

    /*private fun createAuthorizationService(): AuthorizationService {
        Log.i(TAG, "Creating authorization service")
        val builder: AppAuthConfiguration.Builder = Builder()
        builder.setBrowserMatcher(mBrowserMatcher)
        builder.setConnectionBuilder(mConfiguration.getConnectionBuilder())

        return AuthorizationService(this, builder.build())
    }*/

    @MainThread
    private fun displayLoading(loadingMessage: String) {
        findViewById<View>(R.id.loading_container).visibility = View.VISIBLE
        findViewById<View>(R.id.auth_container).visibility = View.GONE
        findViewById<View>(R.id.error_container).visibility = View.GONE

        (findViewById<View>(R.id.loading_description) as TextView).text = loadingMessage
    }

    @MainThread
    private fun displayError(error: String, recoverable: Boolean) {
        findViewById<View>(R.id.error_container).visibility = View.VISIBLE
        findViewById<View>(R.id.loading_container).visibility = View.GONE
        findViewById<View>(R.id.auth_container).visibility = View.GONE

        (findViewById<View>(R.id.error_description) as TextView).text = error
        findViewById<View>(R.id.retry).visibility = if (recoverable) View.VISIBLE else View.GONE
    }

/*
    // WrongThread inference is incorrect in this case
    @AnyThread
    private fun displayErrorLater(error: String, recoverable: Boolean) {
        runOnUiThread(Runnable { displayError(error, recoverable) })
    }*/

    /*@MainThread
    private fun initializeAuthRequest() {
        createAuthRequest()
        warmUpBrowser()
        displayAuthOptions()
    }*/

    @MainThread
    private fun displayAuthOptions() {
        findViewById<View>(R.id.auth_container).visibility = View.VISIBLE
        findViewById<View>(R.id.loading_container).visibility = View.GONE
        findViewById<View>(R.id.error_container).visibility = View.GONE

//        val state: AuthState = mAuthStateManager.getCurrent()
//        val config: AuthorizationServiceConfiguration = state.getAuthorizationServiceConfiguration()
    }

    private fun displayAuthCancelled() {
        Snackbar.make(
            findViewById<View>(R.id.coordinator),
            "Authorization canceled",
            Snackbar.LENGTH_SHORT
        )
            .show()
    }

    /*private fun warmUpBrowser() {
        mAuthIntentLatch = CountDownLatch(1)
        mExecutor.execute {
            Log.i(TAG, "Warming up browser instance for auth request")
            *//*val intentBuilder: CustomTabsIntent.Builder =
                mAuthService.createCustomTabsIntentBuilder(mAuthRequest.get().toUri())
            intentBuilder.setToolbarColor(getColorCompat(R.color.colorPrimary))
            mAuthIntent.set(intentBuilder.build())*//*
            mAuthIntentLatch.countDown()
        }
    }*/

    /*private fun createAuthRequest() {
        val authRequestBuilder: AuthorizationRequest.Builder = Builder(
            mAuthStateManager.getCurrent().getAuthorizationServiceConfiguration(),
            mClientId.get(),
            ResponseTypeValues.CODE,
            mConfiguration.getRedirectUri()
        )
            .setScope(mConfiguration.getScope())

        mAuthRequest.set(authRequestBuilder.build())
    }*/

    /*@TargetApi(Build.VERSION_CODES.M)
    @Suppress("deprecation")
    private fun getColorCompat(@ColorRes color: Int): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getColor(color)
        } else {
            resources.getColor(color)
        }
    }*/

    companion object {
        private const val TAG = "LoginActivity"
        private const val EXTRA_FAILED = "failed"
        private const val RC_AUTH = 100
    }
}
