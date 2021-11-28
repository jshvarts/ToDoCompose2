package com.jshvarts.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.jshvarts.todocompose.ui.theme.HighPriorityColor
import com.jshvarts.todocompose.ui.theme.LowPriorityColor
import com.jshvarts.todocompose.ui.theme.MediumPriorityColor
import com.jshvarts.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}