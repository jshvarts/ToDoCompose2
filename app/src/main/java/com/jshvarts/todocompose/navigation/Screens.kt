package com.jshvarts.todocompose.navigation

import androidx.navigation.NavHostController
import com.jshvarts.todocompose.util.Action
import com.jshvarts.todocompose.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
            // whenever we navigate from task detail back to list, we want to remove task from back stack
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
        // don't pop list screen from back stack
    }
}