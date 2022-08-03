package com.baudelio.test.login.domain

import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun executeAuthUser(request: AuthLoginEmailModel):
            Flow<DataResponse<Pair<AuthModel?, ClaimsModel?>>>
}