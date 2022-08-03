package com.baudelio.test.login.data

import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.login.data.datasource.GetAuthDataSource
import com.baudelio.test.login.domain.AuthRepository
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultAuthRepository(private val getLoginDataSource: GetAuthDataSource) :
    AuthRepository {
    override suspend fun executeAuthUser(request: AuthLoginEmailModel): Flow<DataResponse<Pair<AuthModel?, ClaimsModel?>>> =
        flow {
            emit(getLoginDataSource.executeAuth(request))
        }
}