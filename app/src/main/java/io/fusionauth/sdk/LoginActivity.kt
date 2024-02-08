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
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import io.fusionauth.mobilesdk.AuthenticationConfiguration
import io.fusionauth.mobilesdk.AuthenticationManager
import io.fusionauth.mobilesdk.exceptions.AuthenticationException
import io.fusionauth.mobilesdk.storage.SharedPreferencesStorage
import kotlinx.coroutines.launch

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AuthenticationManager.initialize(
            AuthenticationConfiguration(
                clientId = "21e13847-4f30-4477-a2d9-33c3a80bd15a",
                fusionAuthUrl = "http://10.168.145.33:9011",
                allowUnsecureConnection = true
            ),
            SharedPreferencesStorage(this)
        )

        if (AuthenticationManager.isAuthenticated()) {
            Log.i(TAG, "User is already authenticated, proceeding to token activity")
            startActivity(Intent(this, TokenActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_login)

        findViewById<View>(R.id.retry).setOnClickListener {
            startAuth()
        }
        findViewById<View>(R.id.start_auth).setOnClickListener {
            startAuth()
        }

        if (AuthenticationManager.oAuth(this@LoginActivity).isFailed(intent) ||
            intent.getBooleanExtra(EXTRA_FAILED, false)
        ) {
            displayAuthCancelled()
        }

        displayAuthOptions()
    }

    override fun onDestroy() {
        super.onDestroy()

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
            data?.extras?.let { intent.putExtras(it) }
            startActivity(intent)
        }
    }

    @MainThread
    fun startAuth() {
        displayLoading("Making authorization request")

        lifecycleScope.launch {
            try {
                displayLoading("Making authorization request")
                AuthenticationManager
                    .oAuth(this@LoginActivity)
                    .authorize(
                        PendingIntent.getActivity(
                            this@LoginActivity,
                            0,
                            Intent(this@LoginActivity, TokenActivity::class.java)
                                .putExtra("foo", "bar"),
                            PendingIntent.FLAG_MUTABLE
                        ),
                        PendingIntent.getActivity(
                            this@LoginActivity,
                            0,
                            Intent(this@LoginActivity, LoginActivity::class.java)
                                .putExtra(EXTRA_FAILED, true)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                .putExtra("foo", "bar"),
                            PendingIntent.FLAG_MUTABLE
                        )
                    )
            } catch (e: AuthenticationException) {
                Log.e(TAG, "Error while authorizing", e)
                displayError(e.message ?: "Error while authorizing", true)
            }
        }
    }

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

    @MainThread
    private fun displayAuthOptions() {
        findViewById<View>(R.id.auth_container).visibility = View.VISIBLE
        findViewById<View>(R.id.loading_container).visibility = View.GONE
        findViewById<View>(R.id.error_container).visibility = View.GONE
    }

    private fun displayAuthCancelled() {
        Snackbar.make(
            findViewById<View>(R.id.coordinator),
            "Authorization canceled",
            Snackbar.LENGTH_SHORT
        )
            .show()
    }

    companion object {
        private const val TAG = "LoginActivity"
        private const val EXTRA_FAILED = "failed"
    }
}
