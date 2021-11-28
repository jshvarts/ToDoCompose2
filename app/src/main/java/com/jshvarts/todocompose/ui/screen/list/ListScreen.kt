package com.jshvarts.todocompose.ui.screen.list

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import com.jshvarts.todocompose.R
import com.jshvarts.todocompose.ui.theme.fabBackgroundColor
import com.jshvarts.todocompose.ui.viewmodel.SharedViewModel
import com.jshvarts.todocompose.util.Action
import com.jshvarts.todocompose.util.RequestState
import com.jshvarts.todocompose.util.SearchAppBarState
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(
        key1 = true
    ) {
        Log.d("ListScreen", "LaunchedEffect triggered")
        sharedViewModel.getAllTasks()
    }

    val action by sharedViewModel.action

    val allTasks by sharedViewModel.allTasks.collectAsState()
    (allTasks as? RequestState.Success)?.let {
        for (task in it.data) {
            Log.d("ListScreen", task.title)
        }
    }
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    DisplaySnackBar(
        scaffoldState = scaffoldState,
        handleAction = { sharedViewModel.handleAction(action) },
        action = action,
        taskTitle = sharedViewModel.title.value
    )
    
    Scaffold(
        scaffoldState = scaffoldState, // needed to display a snackbar
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            // FAB is added to standard location in bottom right
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button)
        )
    }
}

@Composable
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    handleAction: () -> Unit,
    action: Action,
    taskTitle: String
) {
    handleAction()

    val scope = rememberCoroutineScope()
    // whenever action changes, LaunchedEffect will be triggered
    LaunchedEffect(key1 = action) {
        if (action != Action.NO_ACTION) {
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "${action.name}: $taskTitle",
                    actionLabel = "OK"
                )
            }
        }
    }

}

//@Composable
//@Preview
//private fun ListScreenPreview() {
//    ListScreen(navigateToTaskScreen = {})
//}