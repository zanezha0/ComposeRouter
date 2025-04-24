package com.zz.router

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import kotlin.reflect.KClass

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 21:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
interface IRouter {
    /**
     * 出栈
     * @param route String
     * @param inclusive Boolean
     */
    fun back(
        route: Any? = null,
        inclusive: Boolean = false,
    )

    /**
     * 导航
     * @param route 目的地路由
     */
    fun to(route: Any)

    /**
     * 导航
     * @param route 目的地路由
     * @param navOptions NavOptions
     * @param navigatorExtras Navigator.Extras?
     *
     */
    fun to(
        route: Any,
        navOptions: NavOptions,
        navigatorExtras: Navigator.Extras?=null
    )

    /**
     * 弹出当前栈并导航到
     * @param route String
     * @param isSingleTop Boolean
     */
    fun replace(
        route: Any,
        isSingleTop: Boolean = false,
    )

    /**
     * 清空导航栈然后导航到route
     * @param route String
     */
    fun offAllTo(
        route: Any,
    )

    /**
     * 出栈 携带数据
     */
    fun backWithResult(route: Any? = null, inclusive: Boolean = false, result: Bundle)

}