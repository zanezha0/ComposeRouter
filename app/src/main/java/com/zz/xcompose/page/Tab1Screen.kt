package com.zz.xcompose.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zz.router.Router
import com.zz.xcompose.nav.OneDestination
import com.zz.xcompose.nav.TwoDestination

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/5/7 17:25.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
@Composable
fun Tab1Screen() {
    val state = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().background(Color(0xfff1fded)).verticalScroll(state), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Button(modifier = Modifier,colors = ButtonDefaults.buttonColors(Color.Magenta), onClick = {
            Router.to(OneDestination)
        }) {
            Text(text = "To OneScreen")
        }

        for (i in 0..100){
            Text(text = "Tab1 Item $i", modifier = Modifier
                .fillMaxWidth()
                .background(if (i % 2 == 0) Color.Red.copy(alpha = 0.5f) else Color.Yellow.copy(alpha = 0.5f))
                .padding(10.dp))
        }
    }
}