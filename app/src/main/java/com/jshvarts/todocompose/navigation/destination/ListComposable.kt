package com.jshvarts.todocompose.navigation.destination

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jshvarts.todocompose.ui.screen.list.ListScreen
import com.jshvarts.todocompose.ui.viewmodel.SharedViewModel
import com.jshvarts.todocompose.util.Constants.LIST_ARG_KEY
import com.jshvarts.todocompose.util.Constants.LIST_SCREEN
import com.jshvarts.todocompose.util.toAction

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARG_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARG_KEY).toAction()
        Log.d("ListComposable", action.name)

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}