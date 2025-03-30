package com.zz.xcompose.page

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.zz.xcompose.nav.FiveDestination
import com.zz.xcompose.nav.FourDestination
import com.zz.xcompose.nav.ThreeDestination
import com.zz.xcompose.nav.TwoDestination
import com.zz.router.Router
import com.zz.xcompose.LocalAppState
import com.zz.xcompose.page.viewmodel.FirstViewModel


@Composable
fun OneScreen() {
    val appState = LocalAppState.current
    val viewModel: FirstViewModel = viewModel()
    val result =  appState?.getBackResult()
    LaunchedEffect(result) {
        if (result != null) {
            viewModel.result.value = result.getString("result")
            println("A 页面收到数据: $result")
        }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "OneScreen", fontSize = 30.sp, color = Color.Red)
        // 显示结果
        val result = viewModel.result.collectAsState()
        Text(text = result.value ?: "No result")

        Button(modifier = Modifier, onClick = {
            Router.to(TwoDestination)
        }) {
            Text(text = "To TwoScreen")
        }
        Button(onClick = {
            Router.to(ThreeDestination("From OneSceen"))
        }) {
            Text(text = "To ThreeScreen")
        }
        Button(onClick = {
            Router.to(FourDestination("From OneSceen", "110"))
        }) {
            Text(text = "To FourScreen")
        }
        Button(onClick = {
            Router.to(FiveDestination(20, "From OneSceen"))
        }) {
            Text(text = "To FiveScreen")
        }
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            Router.back()
        }) {
            Text(text = "Back")
        }
    }
}

