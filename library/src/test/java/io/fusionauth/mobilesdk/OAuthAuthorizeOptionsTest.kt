package io.fusionauth.mobilesdk

import io.fusionauth.mobilesdk.oauth.OAuthAuthorizeOptions
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class OAuthAuthorizeOptionsTest {

    @Test
    fun `prompt defaults to null`() {
        val options = OAuthAuthorizeOptions()
        assertNull(options.prompt)
    }

    @Test
    fun `prompt can be set to login`() {
        val options = OAuthAuthorizeOptions(prompt = "login")
        assertEquals("login", options.prompt)
    }

    @Test
    fun `prompt can be set to consent`() {
        val options = OAuthAuthorizeOptions(prompt = "consent")
        assertEquals("consent", options.prompt)
    }

    @Test
    fun `prompt can be set to none`() {
        val options = OAuthAuthorizeOptions(prompt = "none")
        assertEquals("none", options.prompt)
    }

    @Test
    fun `prompt can be set to select_account`() {
        val options = OAuthAuthorizeOptions(prompt = "select_account")
        assertEquals("select_account", options.prompt)
    }
}
