package com.zz.router

import kotlin.collections.isNotEmpty
import kotlin.collections.joinToString
import kotlin.collections.plusAssign
import kotlin.reflect.full.primaryConstructor

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/4/23 16:19.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */



//生成route模板
inline fun <reified T : Any> generateRouteTemplate(): String {
    val kClass = T::class
    val constructor = kClass.primaryConstructor ?: error("No primary constructor")
    val pathParams = mutableListOf<String>()
    val queryParams = mutableListOf<String>()
    for (param in constructor.parameters) {
        val name = param.name ?: continue
        val isNullable = param.type.isMarkedNullable
        val hasDefault = param.isOptional
        if (hasDefault) {
            // 有默认值 → query 参数
//            queryParams plusAssign "$name={$name}"
            queryParams += "$name={$name}"
        } else {
            // 必填（即使可空） → path 参数
//            pathParams plusAssign "{$name}"
            pathParams += "{$name}"
        }
    }
    val path = pathParams.joinToString("/")
    val query = if (queryParams.isNotEmpty()) "?" + queryParams.joinToString("&") else ""
    val baseRoute = kClass.qualifiedName ?: error("Missing qualified name")
    val route = "$baseRoute/$path$query"
    return route
}




