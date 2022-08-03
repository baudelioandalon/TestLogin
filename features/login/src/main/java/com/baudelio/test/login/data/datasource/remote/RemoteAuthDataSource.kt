package com.baudelio.test.login.data.datasource.remote

import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.login.data.AuthDataSource
import com.baudelio.test.login.data.datasource.GetAuthDataSource
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel

class RemoteAuthDataSource : GetAuthDataSource {
    override suspend fun executeAuth(request: AuthLoginEmailModel): DataResponse<Pair<AuthModel?, ClaimsModel?>> =
        AuthDataSource.getData(request)
}
