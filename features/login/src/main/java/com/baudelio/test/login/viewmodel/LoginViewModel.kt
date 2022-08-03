package com.baudelio.test.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.baudelio.test.core.domain.entity.AuthLoginEmailModel
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import com.baudelio.test.core.utils.base.CUBaseViewModel
import com.baudelio.test.core.utils.base.UseCase
import com.baudelio.test.core.utils.core.DataResponse
import com.baudelio.test.core.utils.core.StatusRequestEnum
import com.baudelio.test.login.usecase.AuthUseCase
import kotlinx.coroutines.flow.collect

class LoginViewModel(
    private val getLoginNormalUseCase: UseCase<AuthUseCase.Input, AuthUseCase.Output>,
) : CUBaseViewModel() {

    val loginData: LiveData<DataResponse<Pair<AuthModel?, ClaimsModel?>>>
        get() = _loginData
    private val _loginData =
        MutableLiveData<DataResponse<Pair<AuthModel?, ClaimsModel?>>>()

    fun requestLogin(request: AuthLoginEmailModel) {
        executeFlow {
            _loginData.postValue(
                DataResponse(StatusRequestEnum.LOADING)
            )
            getLoginNormalUseCase.execute(AuthUseCase.Input(request)).collect {
                _loginData.postValue(it.response)
            }
        }
    }

    fun resetData() {
        _loginData.postValue(DataResponse(StatusRequestEnum.NONE))
    }

}