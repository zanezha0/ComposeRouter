package com.zz.router

import android.app.Activity
import android.content.Intent
import android.os.Bundle

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

    override fun to(route: Any, popUpToRoute: Any?, inclusive: Boolean, isSingleTop: Boolean) {
        navigate(
            RouterIntent.To(
                route = route,
                popUpToRoute = popUpToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop,
            )
        )
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