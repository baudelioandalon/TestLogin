package com.baudelio.test.core.utils.extensions

import androidx.activity.addCallback
import androidx.fragment.app.FragmentActivity


fun FragmentActivity.disableBackButton() {
    onBackPressedDispatcher.addCallback(this) {}
}

fun FragmentActivity.activateBackButton() {
    onBackPressedDispatcher.addCallback(this) {
        onBackPressed()
    }
}