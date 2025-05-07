package com.zz.xcompose.page


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zz.xcompose.nav.OneDestination
import com.zz.xcompose.nav.TwoDestination
import com.zz.router.Router
import com.zz.xcompose.nav.FourDestination


@Composable
fun FourScreen(user: FourDestination) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "FourScreen", fontSize = 30.sp, color = Color.Red)
        Text(text = "name=${user.name}")
        Button(onClick = {
            Router.offAllTo(TwoDestination)
        }) {
            Text(text = "Off Until TwoScreen")
        }
        Button(onClick = {
            Router.offAllTo(OneDestination)
        }) {
            Text(text = "Off Until OneScreen")
        }
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            Router.back()
        }) {
            Text(text = "Back")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun FourScreenPreview() {
    FourScreen(FourDestination("111","xxx"))
}