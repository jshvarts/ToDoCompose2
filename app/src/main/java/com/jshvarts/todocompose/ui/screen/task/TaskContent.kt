package com.jshvarts.todocompose.ui.screen.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jshvarts.todocompose.R
import com.jshvarts.todocompose.component.PriorityDropdown
import com.jshvarts.todocompose.data.models.Priority
import com.jshvarts.todocompose.ui.theme.PADDING_LARGE
import com.jshvarts.todocompose.ui.theme.PADDING_MEDIUM

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(all = PADDING_LARGE)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = {
                Text(text = stringResource(id = R.string.task_title))
            },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier
                .height(PADDING_MEDIUM),
            color = MaterialTheme.colors.background
        )
        PriorityDropdown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = {
                Text(text = stringResource(id = R.string.task_description))
            },
            textStyle = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview
fun TaskContentPreview() {
    TaskContent(
        title = "some title",
        onTitleChange = {},
        description = "some description",
        onDescriptionChange = {},
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}