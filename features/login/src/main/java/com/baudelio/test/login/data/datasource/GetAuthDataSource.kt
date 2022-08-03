package com.baudelio.test.login.data.datasource

import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel


interface GetAuthDataSource {
    suspend fun executeAuth(
        request: AuthLoginEmailModel
    ): DataResponse<Pair<AuthModel?, ClaimsModel?>>

}