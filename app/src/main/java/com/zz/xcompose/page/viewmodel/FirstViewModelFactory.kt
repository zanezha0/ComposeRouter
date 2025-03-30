package com.zz.xcompose.page.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/26 14:10.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
class FirstViewModelFactory(private val savedStateHandle: SavedStateHandle) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FirstViewModel(savedStateHandle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}