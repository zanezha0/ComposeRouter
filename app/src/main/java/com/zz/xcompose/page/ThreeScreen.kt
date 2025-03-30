package com.zz.xcompose.page

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.zz.xcompose.nav.FourDestination
import com.zz.xcompose.nav.OneDestination
import com.zz.xcompose.nav.ThreeDestination
import com.zz.router.Router



@Composable
fun ThreeScreen(id: String) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
            Router.to(route=FourDestination("Replace From Three", "110"),popUpToRoute=ThreeDestination("Three"),inclusive = true)
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