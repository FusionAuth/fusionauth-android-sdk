package io.fusionauth.sdk

import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityWindowInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import io.fusionauth.mobilesdk.AuthorizationManager
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.logging.Logger

/**
 * This class represents a full end-to-end test for the application.
 * It performs a series of UI actions and checks for certain conditions to verify the functionality of the application.
 *
 * @property loginActivityRule The rule used to launch the LoginActivity before each test.
 * @property repeatRule The rule used to repeat the test multiple times.
 */
@RunWith(AndroidJUnit4::class)
internal class FullEnd2EndTest {
    @get:Rule
    val loginActivityRule = ActivityScenarioRule(LoginActivity::class.java)

    @get:Rule
    val repeatRule = RepeatRule()

    @Before
    fun setUp() {
        logger.info("Setting up test")

        Intents.init()

        val automation = InstrumentationRegistry.getInstrumentation().uiAutomation
        val info = automation.serviceInfo
        info.flags = info.flags or AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
        automation.serviceInfo = info
    }

    /**
     * Executes an end-to-end test for the login functionality. It performs the following steps:
     * 1. Clicks the login button.
     * 2. Waits for the login form to appear.
     * 4. Sets the username and password on the login form.
     * 5. Submits the form by pressing the enter key.
     * 6. Waits for the token activity to be displayed.
     * 7. Checks the refresh token functionality.
     * 8. Checks if the token was refreshed.
     * 9. Clicks the sign-out button.
     * 10. Waits for the login activity to be displayed.
     *
     * This test is repeated twice to ensure logout was successful and the login form is displayed again.
     */
    @Test
    @Repeat(2)
    fun e2eTest() {
        logger.info("Click login button")
        onView(withId(R.id.start_auth)).perform(click())
        logger.info("Login button clicked")

        logger.info("Waiting for login form to appear")
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        handleFALoginForm(device, USERNAME, PASSWORD)

        // Check that the token activity is displayed
        device.wait(Until.findObject(By.res("io.fusionauth.app:id/sign_out")), TIMEOUT_MILLIS)
        onView(withId(R.id.sign_out)).check(matches(isDisplayed()))

        logger.info("Token activity displayed")

        // Check refresh token functionality
        val expirationTime = AuthorizationManager.getAccessTokenExpirationTime()!!
        logger.info("Check refresh token")
        onView(withId(R.id.refresh_token))
            .check(matches(isDisplayed()))
            .perform(click())

        val newExpirationTime = AuthorizationManager.getAccessTokenExpirationTime()!!

        logger.info("Token was refreshed (${expirationTime} to ${newExpirationTime})")
        check(newExpirationTime > expirationTime) { "Token was not refreshed" }

        Thread.sleep(1000)

        // Click the sign-out button
        logger.info("Click sign out button")
        onView(withId(R.id.sign_out)).perform(click())

        // Check that the login activity is displayed
        logger.info("Check that the login activity is displayed")
        device.wait(Until.findObject(By.res("io.fusionauth.app:id/start_auth")), TIMEOUT_MILLIS)
        onView(withId(R.id.start_auth)).check(matches(isDisplayed()))

        logger.info("Click login button for second user login")
        onView(withId(R.id.start_auth)).perform(click())
        logger.info("Login button clicked")

        logger.info("Waiting for login form to appear")

        handleFALoginForm(device, USERNAME2, PASSWORD2)

        // Check that the token activity is displayed
        device.wait(Until.findObject(By.res("io.fusionauth.app:id/sign_out")), TIMEOUT_MILLIS)
        onView(withId(R.id.sign_out)).check(matches(isDisplayed()))

        logger.info("Token activity displayed for second user")

        // Click the sign-out button
        logger.info("Click sign out button for second user")
        onView(withId(R.id.sign_out)).perform(click())

        // Check that the login activity is displayed
        logger.info("Check that the login activity is displayed")
        device.wait(Until.findObject(By.res("io.fusionauth.app:id/start_auth")), TIMEOUT_MILLIS)
        onView(withId(R.id.start_auth)).check(matches(isDisplayed()))

    }

    /**
     * Sets the username and password on the login form.
     *
     * @param device The UiDevice used to interact with the UI.
     * @param username The username to set on the login form.
     * @param password The password to set on the login form.
     */
    private fun handleFALoginForm(
        device: UiDevice,
        username: String,
        password: String
    ) {
        device.wait(
            Until.findObject(By.clazz("android.webkit.WebView")),
            TIMEOUT_MILLIS
        )

        val textFields = device.findObjects(By.clazz("android.widget.EditText"))

        closeKeyboardIfOpen()
        logger.info("Set username")
        val userNameInputObject = textFields[0]
        userNameInputObject.setText(username)

        closeKeyboardIfOpen()
        logger.info("Set password")
        val passwordInputObject = textFields[1]
        passwordInputObject.setText(password)

        // Submit the form by pressing the enter key
        logger.info("Submit form by pressing enter key")
        passwordInputObject.click()
        device.pressEnter()
    }

    /**
     * Closes the keyboard if it is open on the screen.
     *
     * When the (automated test) device has a small vertical resolution, the keyboard may be open and cover the login
     * form, thus preventing the UISelector from targeting the form fields.
     *
     * @throws IllegalStateException if the keyboard cannot be closed.
     */
    private fun closeKeyboardIfOpen() {
        val automation = InstrumentationRegistry.getInstrumentation().uiAutomation
        for (window in automation.windows) {
            if (window.type == AccessibilityWindowInfo.TYPE_INPUT_METHOD) {
                UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack()
                return
            }
        }
    }

    @After
    fun tearDown() {
        logger.info("Tearing down test")

        Intents.release()
    }

    companion object {
        private val logger = Logger.getLogger(FullEnd2EndTest::class.java.name)

        private const val USERNAME = "richard@example.com"
        private const val PASSWORD = "password"
        private const val USERNAME2 = "gilfoyle@example.com"
        private const val PASSWORD2 = "password"
        private const val TIMEOUT_MILLIS = 10_000L
    }
}
