package com.zz.router

import android.os.Bundle
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 21:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
sealed class RouterIntent {
    /**
     * 返回堆栈弹出到指定目标
     * @property route 指定目标
     * @property inclusive 是否弹出指定目标
     * 【"4"、"3"、"2"、"1"】 Back("2",true)->【"4"、"3"】
     * 【"4"、"3"、"2"、"1"】 Back("2",false)->【"4"、"3"、"2"】
     */
    data class Back(
        val route: Any? = null,
        val inclusive: Boolean = false,
    ) : RouterIntent()


    /**
     * 导航到指定目标
     * @property route 指定目标
     * @property popUpToRoute 返回堆栈弹出到指定目标
     * @property inclusive 是否弹出指定popUpToRoute目标
     * @property isSingleTop 是否是栈中单实例模式
     */
    data class To(
        val route: Any
    ) : RouterIntent()

    /**
     * 导航到指定目标
     * @property route 指定目标
     * @property navOptions 导航选项  popUp 返回堆栈弹出到指定目标 inclusive 是否弹出指定popUp目标  isSingleTop 是否是栈中单实例模式 popUp 返回堆栈弹出到指定目标
     * @property navigatorExtras 导航扩展
     */
    data class ToWithOptions(
        val route: Any,
        val navOptions: NavOptions,
        val navigatorExtras: Navigator.Extras?=null
    ): RouterIntent()

    /**
     * 替换当前导航/弹出当前导航并导航到指定目的地
     * @property route 当前导航
     * @property isSingleTop 是否是栈中单实例模式
     */
    data class Replace(
        val route: Any,
        val isSingleTop: Boolean = false,
    ) : RouterIntent()

    /**
     * 清空导航栈并导航到指定目的地
     * @property route 指定目的地
     */
    data class OffAllTo(
        val route: Any,
    ) : RouterIntent()

    /**
     * 返回堆栈弹出到指定目标并返回结果
     * @property route 指定目标
     * @property inclusive 是否弹出指定目标
     * @property result 返回结果
     */
    data class BackWithResult(
        val route: Any? = null,
        val inclusive: Boolean = false,
        val result: Bundle,
    ) : RouterIntent()
}