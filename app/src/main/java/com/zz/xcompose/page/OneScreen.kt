package com.zz.xcompose.page

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
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
fun OneScreen( lifecycleOwner:LifecycleOwner = LocalLifecycleOwner.current) {
    val appState = LocalAppState.current
    val viewModel: FirstViewModel = viewModel()
    val result =  appState?.getBackResult()
    LaunchedEffect(result) {
        if (result != null) {
            viewModel.result.value = result.getString("result")
            Log.d("Screen","A 页面收到数据: $result")
        }
    }
    LaunchedEffect(Unit) {
        Log.d("Screen","TwoScreen")
    }
    DisposableEffect(lifecycleOwner) {
        val lifecycleEventObserver = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> Log.d("Screen", "onCreate")
                Lifecycle.Event.ON_START -> Log.d("Screen", "onStart")
                Lifecycle.Event.ON_RESUME -> Log.d("Screen", "onResume")
                Lifecycle.Event.ON_PAUSE -> Log.d("Screen", "onPause")
                Lifecycle.Event.ON_STOP -> Log.d("Screen", "onStop")
                Lifecycle.Event.ON_DESTROY -> Log.d("Screen", "onDestroy")
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(lifecycleEventObserver)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleEventObserver)
        }
    }
    Column(modifier = Modifier.fillMaxSize().background(Color(0xfff1fded)), horizontalAlignment = Alignment.CenterHorizontally) {
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



@Preview(showSystemUi = true)
@Composable
private fun OneScreenPreview() {
    OneScreen()
}