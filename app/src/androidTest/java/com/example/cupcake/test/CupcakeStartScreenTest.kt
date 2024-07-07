package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.cupcake.ui.SelectOptionScreen
import org.junit.Rule
import org.junit.Test
import com.example.cupcake.R
import com.example.cupcake.ui.StartOrderScreen

class CupcakeStartScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun startScreen_verifyContent() {
        // Given list of quantity options
        val quantityOptions = listOf(
            Pair(R.string.one_cupcake, 1),
            Pair(R.string.six_cupcakes, 6),
            Pair(R.string.twelve_cupcakes, 12)
        )

        // When StartScreen is loaded
        composeTestRule.setContent {
            StartOrderScreen(quantityOptions = quantityOptions, onNextButtonClicked = {})

        }

        // Then all the options are displayed on the screen.
        quantityOptions.forEach { quantityOption ->
            composeTestRule.onNodeWithText(quantityOption.first.toString()).assertIsDisplayed()
        }
    }
}