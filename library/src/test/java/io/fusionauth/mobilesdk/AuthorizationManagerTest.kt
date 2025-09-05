package io.fusionauth.mobilesdk

import io.fusionauth.mobilesdk.exceptions.AuthorizationException
import io.fusionauth.mobilesdk.storage.Storage
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verifyNoInteractions

@RunWith(MockitoJUnitRunner::class)
class AuthorizationManagerTest {
    private val mockStorage: Storage = Mockito.mock(Storage::class.java)

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
    fun `resetConfiguration should update the internal configuration successfully`() {
        // Arrange
        val initialConfig = createTestConfig(clientId = "initial-id")
        AuthorizationManager.initialize(initialConfig, mockStorage)

        val internalConfigBefore = AuthorizationManager.getConfiguration()
        assertEquals("initial-id", internalConfigBefore.clientId)

        // Act
        val newConfig = createTestConfig(clientId = "new-id")
        AuthorizationManager.resetConfiguration(newConfig)

        // Assert
        // Verify the internal configuration object has been replaced with the new one
        val internalConfigAfter = AuthorizationManager.getConfiguration()
        assertEquals("new-id", internalConfigAfter.clientId)

        // Verify the AuthorizationManager is initialized
        val isInitialized = AuthorizationManager.isInitialized()
        assertTrue(isInitialized)
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
    fun `resetConfiguration after uninitialized state should throw AuthorizationException`() {
        // Arrange & Act & Assert
        assertThrows(AuthorizationException::class.java) {
            AuthorizationManager.resetConfiguration(createTestConfig())
        }
    }
}
