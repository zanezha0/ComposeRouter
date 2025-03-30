package com.zz.xcompose.page

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.zz.xcompose.nav.OneDestination
import com.zz.router.Router



@Composable
fun FiveScreen(age: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "FiveScreen",  fontSize = 30.sp, color = Color.Red)
        Text(text = "age=$age||name=$name")
        Button(onClick = {
            Router.offAllTo(OneDestination)
        }) {
            Text(text = "Back OneScreen")
        }
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            Router.back()
        }) {
            Text(text = "Back")
        }
    }
}