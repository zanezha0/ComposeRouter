package com.zz.router

import android.os.Bundle

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
     * @param popUpToRoute 弹出路由?
     * @param inclusive 是否也弹出popUpToRoute
     * @param isSingleTop Boolean
     */
    fun to(
        route: Any,
        popUpToRoute: Any? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
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