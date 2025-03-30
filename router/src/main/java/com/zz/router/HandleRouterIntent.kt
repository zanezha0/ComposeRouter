package com.zz.router

import android.R.attr.value
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.takeWhile

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 21:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 * 处理导航意图的收集逻辑
 */
@Composable
fun HandleRouterIntent(
    navController: NavController,
    flow: Flow<RouterIntent>
) {
    val activity = navController.context as? android.app.Activity
    LaunchedEffect(activity, navController, flow) {
        flow.takeWhile { activity?.isFinishing != true }
            .collect { intent ->
                navController.handleComposeNavigationIntent(intent,activity)
                navController.currentBackStack.value.forEachIndexed { index, navBackStackEntry ->
                    Log.d(
                        "NavigationStack",
                        "index:$index=NavigationEffects: ${navBackStackEntry.destination.route}"
                    )
                }
            }
    }
}
