package com.zz.xcompose.page.viewmodel

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/26 14:07.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
class FirstViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val result = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            savedStateHandle.getLiveData<Bundle>("result").observeForever { bundle ->
                bundle?.getString("result")?.let {
                    result.value = it
                }
            }
        }
    }
}