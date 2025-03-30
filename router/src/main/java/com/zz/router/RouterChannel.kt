package com.zz.router

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/3/30 21:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
internal object  RouterChannel {
    private val channel = Channel<RouterIntent>(
        capacity = Int.MAX_VALUE,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )
    internal var routerChannel = channel.receiveAsFlow()
    internal fun navigate(destination: RouterIntent) {
        channel.trySend(destination)
    }
}