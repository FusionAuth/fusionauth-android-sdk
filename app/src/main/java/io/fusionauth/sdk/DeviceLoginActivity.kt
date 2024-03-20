package io.fusionauth.sdk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import io.fusionauth.mobilesdk.AuthorizationManager
import io.fusionauth.mobilesdk.ExperimentalApi
import io.fusionauth.mobilesdk.exceptions.AuthorizationException
import kotlinx.coroutines.launch

/**
 * Demonstrates the usage of the FusionAuth SDK to authorize a user utilizing the Device Authorization
 * Grant. This is useful for devices that do not have a browser or other input mechanism.
 */
class DeviceLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_device_login)

        findViewById<View>(R.id.device_login).setOnClickListener {
            startAuth()
        }

        displayAuthOptions()
    }

    @OptIn(ExperimentalApi::class)
    @MainThread
    fun startAuth() {
        displayLoading("Starting device authorization request")

        lifecycleScope.launch {
            try {
                val deviceCodeResponse = AuthorizationManager
                    .oAuth(this@DeviceLoginActivity)
                    .deviceAuthorize()

                findViewById<TextView>(R.id.device_code_code).let {
                    (it as TextView).text = deviceCodeResponse.user_code
                }
                findViewById<TextView>(R.id.device_code_link).let {
                    (it as TextView).text = deviceCodeResponse.verification_uri
                }

                BarcodeEncoder().encodeBitmap(
                    deviceCodeResponse.verification_uri_complete,
                    BarcodeFormat.QR_CODE,
                    QR_CODE_DIMENSION, QR_CODE_DIMENSION
                )
                    .let { bitmap ->
                        findViewById<ImageView>(R.id.device_code_qr).setImageBitmap(bitmap)
                    }

                displayDeviceCode()

                displayLoading("Polling for authorization")

                val authState = AuthorizationManager
                    .oAuth(this@DeviceLoginActivity)
                    .getDeviceFusionAuthState(deviceCodeResponse)

                // Is logged in!
                startActivity(Intent(this@DeviceLoginActivity, TokenActivity::class.java))
            } catch (e: AuthorizationException) {
                Log.e(DeviceLoginActivity.TAG, "Error while authorizing", e)
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
        findViewById<View>(R.id.device_code_container).visibility = View.GONE
        findViewById<View>(R.id.auth_container).visibility = View.VISIBLE
        findViewById<View>(R.id.loading_container).visibility = View.GONE
        findViewById<View>(R.id.error_container).visibility = View.GONE
    }

    @MainThread
    private fun displayDeviceCode() {
        findViewById<View>(R.id.device_code_container).visibility = View.VISIBLE
        findViewById<View>(R.id.auth_container).visibility = View.GONE
        findViewById<View>(R.id.loading_container).visibility = View.GONE
        findViewById<View>(R.id.error_container).visibility = View.GONE
    }

    companion object {
        private const val TAG = "DeviceLoginActivity"
        private const val QR_CODE_DIMENSION = 512
    }

}
