package com.baudelio.test.login.ui

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.baudelio.test.core.utils.ACCESS_MODEL
import com.baudelio.test.core.utils.base.CUBaseFragment
import com.baudelio.test.core.utils.core.StatusRequestEnum
import com.baudelio.test.core.utils.extensions.showToast
import com.baudelio.test.login.R
import com.baudelio.test.login.databinding.LoginFragmentBinding
import com.baudelio.test.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : CUBaseFragment<LoginFragmentBinding>() {

    val viewModel: LoginViewModel by sharedViewModel()

    override fun getLayout() = R.layout.login_fragment

    override fun initObservers() {
        viewModel.loginData.observe(viewLifecycleOwner) {
            it?.let { result ->
                when (result.statusRequest) {
                    StatusRequestEnum.LOADING -> showProgress()
                    StatusRequestEnum.NONE -> {
                        hideProgressBarCustom()
                    }
                    else -> {
                        hideProgressBarCustom()
                        if (result.statusRequest == StatusRequestEnum.SUCCESS) {
                            Bundle().apply {
                                putSerializable(ACCESS_MODEL, it.successData)
                                findNavController().navigate(R.id.nav_home_graph, this)
                            }
                            viewModel.resetData()
                        } else {
                            showToast(
                                result.errorModel?.msg ?: result.errorData
                                ?: "Por favor, intente mas tarde."
                            )
                        }
                    }
                }
            }
        }
    }

    override fun initView() {
        initElements()
    }
}