package com.zz.xcompose.page

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.navOptions
import com.zz.xcompose.nav.FourDestination
import com.zz.xcompose.nav.OneDestination
import com.zz.xcompose.nav.ThreeDestination
import com.zz.router.Router
import com.zz.router.generateRouteTemplate


@Composable
fun ThreeScreen(id: String) {

    Column(modifier = Modifier.fillMaxSize().background(Color(0xfff1fded)),horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "ThreeScreen",  fontSize = 30.sp, color = Color.Red)
        Text(text = "id=$id")
        Button(onClick = {
            Router.offAllTo(OneDestination)
        }) {
            Text(text = "Back OneScreen")
        }
        Button(onClick = {
            Router.to(FourDestination("From Three", "110"))
        }) {
            Text(text = "To FourScreen")
        }
        Button(onClick = {
            val navOptions = navOptions {
                popUpTo<ThreeDestination> {
                    saveState = true
                    inclusive = true
                }
                launchSingleTop = true
                restoreState = true
            }
            Router.to(route=FourDestination("Replace From Three", "110"),navOptions=navOptions)
        }) {
            Text(text = "Replace FourScreen")
        }
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            Router.back()
        }) {
            Text(text = "Back")
        }

        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            val bundle = Bundle().apply {
                putString("result", "Three Screen Back Result Data")
            }
            Router.backWithResult(OneDestination,  result = bundle)
        }) {
            Text(text = "Back for result")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ThreeScreenPreview() {
    ThreeScreen("111")
}