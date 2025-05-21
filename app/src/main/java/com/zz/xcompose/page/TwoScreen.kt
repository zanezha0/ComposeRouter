package com.zz.xcompose.page

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zz.xcompose.nav.ThreeDestination
import com.zz.router.Router

@Composable
fun TwoScreen() {
    LaunchedEffect(Unit) {
        Log.d("Screen","TwoScreen")
    }
    Column(modifier = Modifier.fillMaxSize().background(Color(0xfff1fded)),horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TwoScreen",  fontSize = 30.sp, color = Color.Red)
        Button(onClick = {
            Router.to(ThreeDestination("FromTwo"))
        }) {
            Text(text = "To ThreeScreen")
        }
        Button(onClick = {
            Router.replace(ThreeDestination("Replace From Two"))
        }) {
            Text(text = "Replace To ThreeScreen")
        }
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            Router.back()
        }) {
            Text(text = "Back")
        }
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            val bundle = Bundle().apply {
                putString("result", "Two Screen Back Result Data")
            }
            Router.backWithResult(result = bundle)
        }) {
            Text(text = "Back for result")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun TwoScreenPreview() {
    TwoScreen()
}