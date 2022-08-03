package com.baudelio.test.core.utils.roundablelayout

import androidx.core.content.ContextCompat

fun CURoundableLayout.changeBackgroundColor(color: Int) {
    backgroundColor = ContextCompat.getColor(context, color)
}