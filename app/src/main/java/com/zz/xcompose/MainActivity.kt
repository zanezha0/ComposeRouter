package com.zz.xcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.Upcoming
import androidx.compose.material.icons.rounded.Bookmarks
import androidx.compose.material.icons.rounded.Commute
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ManageAccounts
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
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.zz.router.Router
import com.zz.xcompose.nav.MainDestination
import com.zz.xcompose.nav.Tab1Destination
import com.zz.xcompose.nav.Tab2Destination
import com.zz.xcompose.nav.XNavigationBar
import com.zz.xcompose.nav.XNavigationBarItem
import com.zz.xcompose.page.MainScreen
import com.zz.xcompose.ui.theme.XComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val tabList = listOf(
            TabEntity("HOME", Icons.Outlined.Home, Icons.Rounded.Home, Tab1Destination),
            TabEntity("MY", Icons.Outlined.ManageAccounts, Icons.Rounded.ManageAccounts, Tab2Destination),
        )
        setContent {
            var selectIndex = remember { mutableIntStateOf(0) }
            val appState = rememberAppState()
            val navBackStackEntry = appState.navController.currentBackStackEntryAsState().value
            val currentRoute = navBackStackEntry?.destination?.route
            Log.e("currentRoute", currentRoute + "")
            val tempIndex = tabList.indexOfFirst { it.router.javaClass.name == currentRoute }
            selectIndex.value = if ( tempIndex>=0) tempIndex else 0
            XComposeTheme {
                CompositionLocalProvider(LocalAppState provides appState) {
                    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                        if (currentRoute in tabList.map { it.router.javaClass.name } || currentRoute == null) {
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
                        }
                    }) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding),
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