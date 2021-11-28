package com.jshvarts.todocompose.util

object Constants {
    const val DATABASE_TABLE = "todo_table"
    const val DATABASE_NAME = "todo_database"

    // composable screen: route name slash composable argument:
    const val LIST_SCREEN = "list/{action}"
    const val TASK_SCREEN = "task/{taskId}"

    const val LIST_ARG_KEY = "action"
    const val TASK_ARG_KEY = "taskId"

    const val MAX_TITLE_LENGTH = 30
}