package com.baudelio.test.core.utils.base

import android.view.View
import androidx.annotation.RawRes
import com.airbnb.lottie.LottieAnimationView
import com.baudelio.test.core.R

interface CUBackHandler {
    fun showProgress(
        message: String? = null,
        isCancelable: Boolean = false,
        @RawRes lottieResource: Int? = R.raw.a_loading_lottie
    )

    fun hideProgress()
    fun hideKeyBoard()
    fun showKeyBoard(viewEditable: View, requestFocused: Boolean = true)
    fun showLottie(
        lottie: LottieAnimationView,
        containerPersonality: View,
        containerParent: View, show: Boolean
    )
}