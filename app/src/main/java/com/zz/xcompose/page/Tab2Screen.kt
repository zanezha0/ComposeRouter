package com.zz.xcompose.page

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zz.router.Router
import com.zz.xcompose.nav.Tab1Destination

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/5/7 17:25.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
@Composable
fun Tab2Screen() {
    val state = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state), horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
            Router.switchTab(Tab1Destination)
        }) {
            Text(text = "Switch to Tab1")
        }
        for (i in 0..100){
            Text(text = "item $i", modifier = Modifier
                .fillMaxWidth()
                .background(if (i % 2 == 0) Color.Red.copy(alpha = 0.5f) else Color.Blue.copy(alpha = 0.5f))
                .padding(10.dp))
        }
    }
}