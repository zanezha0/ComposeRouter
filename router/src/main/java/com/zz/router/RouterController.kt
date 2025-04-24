package com.zz.router

import android.app.Activity
import androidx.navigation.NavController
/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 21:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
fun NavController.handleComposeNavigationIntent(intent: RouterIntent, activity: Activity?) {
    when (intent) {
        is RouterIntent.Back -> {
            if (intent.route != null) {
                popBackStack(intent.route, intent.inclusive)
            } else {
                if (currentBackStackEntry == null || currentBackStackEntry?.destination?.route==null) {
                    // 返回栈为空时退出 Activity
                    activity?.finish()
                } else {
                    popBackStack()
                }
            }
        }
        is RouterIntent.To -> {
            navigate(intent.route)
        }

        is RouterIntent.ToWithOptions -> {
            navigate(intent.route, intent.navOptions,intent.navigatorExtras)
        }

        is RouterIntent.Replace -> {
            navigate(intent.route) {
                launchSingleTop = intent.isSingleTop
                currentBackStackEntry?.destination?.route?.let {
                    popBackStack()
                }
            }
        }

        is RouterIntent.OffAllTo -> navigate(intent.route) {
            popUpTo(0)
        }

        is RouterIntent.BackWithResult -> {
            if (intent.route != null) {
                previousBackStackEntry?.savedStateHandle?.set("result", intent.result)
                popBackStack(intent.route, intent.inclusive)
            } else {
                if (currentBackStackEntry == null  || currentBackStackEntry?.destination?.route==null) {
                    // 返回栈为空时退出 Activity
                    activity?.finish()
                } else {
                    previousBackStackEntry?.savedStateHandle?.set("result", intent.result)
                    popBackStack()
                }
            }
        }
    }
}