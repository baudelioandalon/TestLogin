package com.baudelio.test.login.usecase

import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.utils.base.In
import com.baudelio.test.core.utils.base.Out
import com.baudelio.test.core.utils.base.UseCase
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.login.domain.AuthRepository
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class AuthUseCase(private val authRepository: AuthRepository) :
    UseCase<AuthUseCase.Input, AuthUseCase.Output> {

    class Input(val request: AuthLoginEmailModel) : In()
    inner class Output(val response: DataResponse<Pair<AuthModel?, ClaimsModel?>>) : Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return authRepository.executeAuthUser(input.request).flowOn(Dispatchers.IO).map {
            Output(it)
        }
    }

}