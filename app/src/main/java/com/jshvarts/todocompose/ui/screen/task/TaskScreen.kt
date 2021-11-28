package com.jshvarts.todocompose.ui.screen.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.jshvarts.todocompose.data.models.ToDoTask
import com.jshvarts.todocompose.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {}
    )
}