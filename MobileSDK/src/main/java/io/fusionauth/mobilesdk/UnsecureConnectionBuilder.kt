package io.fusionauth.mobilesdk

import android.net.Uri
import net.openid.appauth.connectivity.ConnectionBuilder
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.TimeUnit

object SingletonUnsecureConnectionBuilder : ConnectionBuilder by UnsecureConnectionBuilder()

private const val CONNECTION_TIMEOUT_SECONDS = 1000L
private const val READ_TIMEOUT_SECONDS = 10L

internal val CONNECTION_TIMEOUT_MS: Int = TimeUnit.SECONDS.toMillis(CONNECTION_TIMEOUT_SECONDS).toInt()
internal val READ_TIMEOUT_MS: Int = TimeUnit.SECONDS.toMillis(READ_TIMEOUT_SECONDS).toInt()

class UnsecureConnectionBuilder : ConnectionBuilder {
    @Throws(IOException::class)
    override fun openConnection(uri: Uri): HttpURLConnection {
        val conn = URL(uri.toString()).openConnection() as HttpURLConnection
        conn.connectTimeout = CONNECTION_TIMEOUT_MS
        conn.readTimeout = READ_TIMEOUT_MS
        conn.instanceFollowRedirects = false
        return conn
    }
}
