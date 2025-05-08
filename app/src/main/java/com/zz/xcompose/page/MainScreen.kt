package com.zz.xcompose.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.Upcoming
import androidx.compose.material.icons.rounded.Bookmarks
import androidx.compose.material.icons.rounded.Upcoming
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.zz.router.Router
import com.zz.xcompose.TabEntity
import com.zz.xcompose.nav.Tab1Destination
import com.zz.xcompose.nav.Tab2Destination
import com.zz.xcompose.nav.XNavigationBar
import com.zz.xcompose.nav.XNavigationBarItem

/**
 * Copyright © 2025 zhun All rights reserved.
 * Created by ZhaoZhun on 2025/5/8 17:20.
 * @author: ZhaoZhun 1820022519@qq.com
 * @version: V1.0
 */
@Composable
fun MainScreen() {
    var selectIndex  = remember { mutableIntStateOf(0) }
    val tabList = listOf(
        TabEntity("Tab1", Icons.Outlined.Upcoming, Icons.Rounded.Upcoming, Tab1Destination),
        TabEntity("Tab2", Icons.Outlined.Bookmarks, Icons.Rounded.Bookmarks, Tab2Destination),
    )
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        XNavigationBar {
            tabList.forEachIndexed { index, item ->
                XNavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                        )
                    },
                    selectedIcon = {
                        Icon(
                            imageVector = item.selectedIcon,
                            contentDescription = item.title,
                        )
                    },
                    label = { Text(item.title) },
                    selected = index == selectIndex.value,
                    onClick = {
                        selectIndex.value = index
                        Router.switchTab(item.router)
                    },
                )
            }
        }
    }) { innerPadding ->

    }
}