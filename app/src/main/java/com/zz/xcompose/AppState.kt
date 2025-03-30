package com.zz.xcompose

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 13:48.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        AppState(
            navController = navController,
            coroutineScope = coroutineScope,
        )
    }
}

@Stable
class AppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    fun getBackResult(key: String = "result"): Bundle? {
        val backStackEntry =  navController.currentBackStackEntry
        val result = backStackEntry?.savedStateHandle?.get<Bundle>(key)
        //清除数据
        backStackEntry?.savedStateHandle?.remove<Bundle>(key)
        return result
    }
}