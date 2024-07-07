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
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.StartOrderScreen

class CupcakeSummaryScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun summaryScreen_verifyContent() {
        // Given orderUiState
        val orderUiState = OrderUiState(
            quantity = 6,
            flavor = "Salted Caramel",
            date = "Tue Jul 9",
            price = "$12.00")

        // When SummaryScreen is loaded
        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = orderUiState,
                onCancelButtonClicked = {},
                onSendButtonClicked =  {_,_->}
            )
        }

        // Then all details of the order are displayed on the screen.
        composeTestRule.onNodeWithText(orderUiState.quantity.toString()+ " cupcakes").assertIsDisplayed()
        composeTestRule.onNodeWithText(orderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(orderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                com.example.cupcake.R.string.subtotal_price,
                orderUiState.price
            )
        ).assertIsDisplayed()    }
}