package com.zz.xcompose.page

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Button(modifier = Modifier, onClick = {
        Router.to(OneDestination)
    }) {
        Text(text = "To OneScreen")
    }
}