package io.fusionauth.mobilesdk

import io.fusionauth.mobilesdk.exceptions.AuthorizationException
import io.fusionauth.mobilesdk.storage.Storage
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verifyNoInteractions

@RunWith(MockitoJUnitRunner::class)
class AuthorizationManagerTest {

    @Mock
    private val mockStorage: Storage = Mockito.mock(Storage::class.java)

    /**
     * The singleton 'object' AuthorizationManager holds state across test runs.
     * Reset it before and after each test to ensure test isolation.
     */
    @Before
    fun setUp() {
        AuthorizationManager.dispose()
    }

    @After
    fun tearDown() {
        AuthorizationManager.dispose()
    }

    /**
     * A helper function to create a standard configuration for tests.
     */
    private fun createTestConfig(clientId: String = "default-client-id"): AuthorizationConfiguration {
        return AuthorizationConfiguration(
            fusionAuthUrl = "https://test.fusionauth.io",
            clientId = clientId
        )
    }

    @Test
    fun `resetConfiguration when not initialized should throw AuthorizationException`() {
        // Arrange: AuthorizationManager is in an uninitialized state.

        // Act & Assert
        val exception = assertThrows(AuthorizationException::class.java) {
            AuthorizationManager.resetConfiguration(createTestConfig())
        }

        // Assert the exception message is as expected
        assertEquals("AuthorizationManager must be initialized by calling initialize() first.", exception.message)
    }

    @Test
    fun `resetConfiguration should update the internal configuration successfully`() {
        // Arrange
        val initialConfig = createTestConfig(clientId = "initial-id")
        AuthorizationManager.initialize(initialConfig, mockStorage)

        // Use reflection to verify the initial state, since 'configuration' is private
        val configurationField = AuthorizationManager.javaClass.getDeclaredField("configuration")
        configurationField.isAccessible = true
        val internalConfigBefore = configurationField.get(AuthorizationManager) as AuthorizationConfiguration
        assertEquals("initial-id", internalConfigBefore.clientId)

        // Act
        val newConfig = createTestConfig(clientId = "new-id")
        AuthorizationManager.resetConfiguration(newConfig)

        // Assert
        // Verify the internal configuration object has been replaced with the new one
        val internalConfigAfter = configurationField.get(AuthorizationManager) as AuthorizationConfiguration
        assertEquals("new-id", internalConfigAfter.clientId)
    }

    @Test
    fun `resetConfiguration should not interact with the storage`() {
        // Arrange
        val initialConfig = createTestConfig()
        AuthorizationManager.initialize(initialConfig, mockStorage)

        // Act
        val newConfig = createTestConfig(clientId = "new-id")
        AuthorizationManager.resetConfiguration(newConfig)

        // Assert
        // Verify that no methods were called on the mockStorage. This is crucial because
        // it proves that resetting the configuration does not have the side effect of
        // clearing the stored authentication state.
        verifyNoInteractions(mockStorage)
    }

    @Test
    fun `resetConfiguration after dispose should throw AuthorizationException`() {
        // Arrange
        AuthorizationManager.initialize(createTestConfig(), mockStorage)
        AuthorizationManager.dispose() // Reset the manager to its uninitialized state

        // Act & Assert
        assertThrows(AuthorizationException::class.java) {
            AuthorizationManager.resetConfiguration(createTestConfig())
        }
    }
}
