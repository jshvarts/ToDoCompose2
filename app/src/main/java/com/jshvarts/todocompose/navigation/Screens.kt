package com.jshvarts.todocompose.navigation

import androidx.navigation.NavHostController
import com.jshvarts.todocompose.util.Action
import com.jshvarts.todocompose.util.Constants.LIST_SCREEN
import com.jshvarts.todocompose.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
        // don't pop list screen from back stack
    }

    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
            // whenever we navigate from task detail back to list, we want to remove task from back stack
        }
    }
}