package com.zz.xcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.Upcoming
import androidx.compose.material.icons.rounded.Bookmarks
import androidx.compose.material.icons.rounded.Upcoming
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zz.router.Router
import com.zz.xcompose.nav.Tab1Destination
import com.zz.xcompose.nav.Tab2Destination
import com.zz.xcompose.nav.XNavigationBar
import com.zz.xcompose.nav.XNavigationBarItem
import com.zz.xcompose.ui.theme.XComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val tabList = listOf(
            TabEntity("Tab1", Icons.Outlined.Upcoming, Icons.Rounded.Upcoming, Tab1Destination),
            TabEntity("Tab2", Icons.Outlined.Bookmarks, Icons.Rounded.Bookmarks, Tab2Destination),
        )
        setContent {
            var selectIndex  = remember { mutableIntStateOf(0) }
            val appState = rememberAppState()
            val navBackStackEntry = appState.navController.currentBackStackEntryAsState().value
            val currentRoute = navBackStackEntry?.destination?.route
            XComposeTheme {
                CompositionLocalProvider(LocalAppState provides appState) {
//                    if (currentRoute in tabList.map { it.router }.toList())
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
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .padding(top = 100.dp),
                            contentAlignment = androidx.compose.ui.Alignment.TopCenter,
                        ) {
                            RouterEffectSample(appState)
                        }

                    }
                }
            }
        }
    }
}

var LocalAppState = compositionLocalOf<AppState?> { null }