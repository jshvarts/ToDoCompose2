package com.jshvarts.todocompose.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jshvarts.todocompose.R
import com.jshvarts.todocompose.ui.theme.LOGO_HEIGHT
import com.jshvarts.todocompose.ui.theme.ToDoComposeTheme
import com.jshvarts.todocompose.ui.theme.splashScreenBackground
import com.jshvarts.todocompose.util.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToTaskScreen: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(SPLASH_SCREEN_DELAY)
        navigateToTaskScreen()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashScreenBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(LOGO_HEIGHT),
            painter = painterResource(id = getLogoRes()),
            contentDescription = stringResource(id = R.string.todo_logo)
        )
    }
}

// need to be Composable since it calls isSystemInDarkTheme() Composable function
@Composable
private fun getLogoRes(): Int {
    return if (isSystemInDarkTheme()) {
        R.drawable.ic_logo_dark
    } else {
        R.drawable.ic_logo_light
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    // light theme (default)
    SplashScreen(navigateToTaskScreen = { })
}

@Composable
@Preview
fun SplashScreenDarkModePreview() {
    ToDoComposeTheme(darkTheme = true) {
        SplashScreen(navigateToTaskScreen = { })
    }
}