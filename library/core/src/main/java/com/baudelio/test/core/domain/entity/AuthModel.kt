package com.baudelio.test.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthModel(
    val success: Boolean,
    val token: String
) : Parcelable