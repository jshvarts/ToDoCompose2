package com.jshvarts.todocompose.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jshvarts.todocompose.ui.screen.splash.SplashScreen
import com.jshvarts.todocompose.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToTaskScreen: () -> Unit
) {
    composable(route = SPLASH_SCREEN) {
        SplashScreen(navigateToTaskScreen = navigateToTaskScreen)
    }
}