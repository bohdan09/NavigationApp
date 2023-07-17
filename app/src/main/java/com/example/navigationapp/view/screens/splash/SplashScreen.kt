package com.example.navigationapp.view.screens.splash

import android.animation.ObjectAnimator
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

fun ComponentActivity.startSplashScreen() {
    val splashFadeDurationMillis = 1000
    val splashScreen = installSplashScreen()
    val viewModel by viewModels<SplashScreenViewModel>()
    splashScreen.setKeepOnScreenCondition {
        viewModel.nextScreen.value == null
    }

    splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
        splashScreenViewProvider.iconView
            .animate()
            .setDuration(splashFadeDurationMillis.toLong())
            .scaleXBy(0.5f)
            .scaleYBy(0.5f)
            .start()

        val alpha = ObjectAnimator.ofFloat(
            splashScreenViewProvider.view,
            "alpha",
            1F, 0F
        ).setDuration(300)
        alpha.doOnEnd {
            splashScreenViewProvider.remove()
        }
        alpha.startDelay = splashFadeDurationMillis.toLong()
        alpha.start()
    }
}
