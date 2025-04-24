package com.zz.router

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 21:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
object Router: IRouter {

    private fun navigate(destination: RouterIntent) {
        RouterChannel.navigate(destination)
    }

    override fun back(route: Any?, inclusive: Boolean) {
        navigate(
            RouterIntent.Back(
                route = route,
                inclusive = inclusive,
            )
        )
    }

    override fun to(route: Any) {
        navigate(
            RouterIntent.To(
                route = route
            )
        )
    }

    override fun to(route: Any, navOptions: NavOptions, navigatorExtras: Navigator.Extras?) {
        navigate(RouterIntent.ToWithOptions(route = route,navOptions,navigatorExtras))
    }

    override fun replace(route: Any, isSingleTop: Boolean) {
        navigate(
            RouterIntent.Replace(
                route = route,
                isSingleTop = isSingleTop,
            )
        )
    }

    override fun offAllTo(route: Any) {
        navigate(RouterIntent.OffAllTo(route))
    }

    override fun backWithResult(route: Any?, inclusive: Boolean, result: Bundle) {
        navigate(
            RouterIntent.BackWithResult(
                route = route,
                inclusive = inclusive,
                result = result
            ),
        )
    }
}