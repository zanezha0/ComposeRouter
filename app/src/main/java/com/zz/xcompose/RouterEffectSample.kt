package com.zz.xcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.zz.xcompose.nav.FiveDestination
import com.zz.xcompose.nav.FourDestination
import com.zz.xcompose.nav.OneDestination
import com.zz.xcompose.nav.ThreeDestination
import com.zz.xcompose.nav.TwoDestination
import com.zz.xcompose.page.FiveScreen
import com.zz.xcompose.page.FourScreen
import com.zz.xcompose.page.OneScreen
import com.zz.xcompose.page.ThreeScreen
import com.zz.xcompose.page.TwoScreen
import com.zz.router.RouterEffect
import com.zz.xcompose.nav.MainDestination
import com.zz.xcompose.nav.Tab1Destination
import com.zz.xcompose.nav.Tab2Destination
import com.zz.xcompose.page.MainScreen
import com.zz.xcompose.page.Tab1Screen
import com.zz.xcompose.page.Tab2Screen


@Composable
fun RouterEffectSample(appState: AppState) {
    RouterEffect(
        navController = appState.navController,
        startDestination = Tab1Destination,
    ) {
        composable<MainDestination> {
            MainScreen()
        }
        composable<Tab1Destination> {
            Tab1Screen()
        }
        composable<Tab2Destination> {
            Tab2Screen()
        }
        composable<OneDestination> {
            OneScreen()
        }
        composable<TwoDestination> {
            TwoScreen()
        }
        composable<ThreeDestination> { backStackEntry ->
            val entity: ThreeDestination = backStackEntry.toRoute()
            ThreeScreen(entity.channelId)
        }

        composable<FourDestination> { backStackEntry ->
            val entity: FourDestination = backStackEntry.toRoute()
            FourScreen(entity)
        }

        composable<FiveDestination> { backStackEntry ->
            val entity: FiveDestination = backStackEntry.toRoute()
            val age = entity.age
            val name = entity.name
            FiveScreen(age, name)
        }

    }
}


