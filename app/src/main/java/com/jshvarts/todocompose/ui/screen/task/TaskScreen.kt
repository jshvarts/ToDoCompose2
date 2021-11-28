package com.jshvarts.todocompose.ui.screen.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.jshvarts.todocompose.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
                 TaskAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {}
    )
}