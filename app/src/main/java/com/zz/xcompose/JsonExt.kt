package com.zz.xcompose

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken


/**
 * Copyright © 2024 zhun All rights reserved.
 * Created by Zha0Zhun on 2024/6/8 11:57.
 * @author: Zha0Zhun 1820022519@qq.com
 * @version: V1.0
 */
fun Any.toJson() = GsonBuilder().setPrettyPrinting().create().toJson(this)

inline fun <reified T> String.fromJson() = Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)

inline fun <reified T> String?.fromJsonNullable() = if (this == null) { null } else {
    try {
        Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

inline fun <reified T> String.toBean() = Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)

inline fun String.toHashMap() = this.fromJson<HashMap<String, Any>>()

inline fun Any.toHashMap() = this.toJson().fromJson<HashMap<String, Any>>()