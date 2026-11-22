package com.tomildev.weatdot.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * A JUnit [TestWatcher] rule that overrides [Dispatchers.Main] with a [TestDispatcher]
 * for local JVM unit testing.
 *
 * In Android unit tests (JVM), the main thread ([Dispatchers.Main]) is not available
 * because the Android OS main looper is not running. This rule replaces [Dispatchers.Main]
 * before each test starts and resets it after the test finishes, allowing Coroutines and
 * ViewModels using [Dispatchers.Main] or `viewModelScope` to execute properly.
 *
 * Usage:
 * ```kotlin
 * @get:Rule
 * val mainDispatcherRule = MainDispatcherRule()
 * ```
 *
 * @property testDispatcher The [TestDispatcher] instance used to execute main-thread coroutines.
 */

@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {

    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}