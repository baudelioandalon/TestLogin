package com.baudelio.test.core.utils.extensions

import android.text.TextUtils
import android.widget.EditText

fun EditText.isValidEmail() =
    if (TextUtils.isEmpty(text.toString().replace(" ", ""))) {
        false
    } else {
        android.util.Patterns.EMAIL_ADDRESS.matcher(text.toString().replace(" ", "")).matches()
    }