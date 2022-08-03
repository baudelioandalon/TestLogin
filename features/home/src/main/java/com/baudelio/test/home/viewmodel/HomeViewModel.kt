package com.baudelio.test.home.viewmodel

import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import com.baudelio.test.core.utils.base.CUBaseViewModel

class HomeViewModel : CUBaseViewModel() {

    private var dataLoggin: Pair<AuthModel?, ClaimsModel?> = Pair(null, null)

    fun setData(data: Pair<AuthModel?, ClaimsModel?>) {
        dataLoggin = data
    }

    fun getAuthModel() = dataLoggin.first ?: AuthModel(false, "")
    fun getClaims() = dataLoggin.second ?: ClaimsModel("", "", "", "")
}