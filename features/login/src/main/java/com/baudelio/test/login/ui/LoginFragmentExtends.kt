package com.baudelio.test.login.ui

import android.view.animation.AnimationUtils
import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.utils.extensions.isValidEmail
import com.baudelio.test.core.utils.extensions.onClick
import com.baudelio.test.core.utils.extensions.showToast
import com.baudelio.test.login.R

fun LoginFragment.initElements() {
    binding.apply {
        btnLogin.onClick {
            if (txtEmail.isValidEmail()) {
                viewModel.requestLogin(
                    request = AuthLoginEmailModel(
                        email = txtEmail.text.toString().trim().trimIndent(),
                        token = txtPassword.text.toString().trim().trimIndent()
                    )
                )
            } else {
                showToast("Ingrese un correo valido")
            }
        }
    }
    initAnimations()
}

fun LoginFragment.initAnimations() {
    binding.apply {
        imgOne.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in))
        imgTwo.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_left))
        imgLogo.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in))
        imgTop.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.slide_down))
    }
}