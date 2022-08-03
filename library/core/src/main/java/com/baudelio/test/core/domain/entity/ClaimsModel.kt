package com.baudelio.test.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClaimsModel(
    val titular: String,
    val url: String,
    val email: String,
    val solicitud: String
) : Parcelable