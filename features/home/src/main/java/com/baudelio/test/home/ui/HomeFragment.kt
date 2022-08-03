package com.baudelio.test.home.ui

import android.os.Bundle
import com.baudelio.test.core.domain.entity.AuthModel
import com.baudelio.test.core.domain.entity.ClaimsModel
import com.baudelio.test.core.utils.ACCESS_MODEL
import com.baudelio.test.core.utils.base.CUBaseFragment
import com.baudelio.test.core.utils.extensions.showToast
import com.baudelio.test.home.R
import com.baudelio.test.home.databinding.HomeFragmentBinding
import com.baudelio.test.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : CUBaseFragment<HomeFragmentBinding>() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            try {
                val data = it.getSerializable(ACCESS_MODEL) as Pair<AuthModel?, ClaimsModel?>
                viewModel.setData(data)
            } catch (exception: Exception) {
                showToast("El modelo de respuesta es distinto")
                onFragmentBackPressed()
            }
        }
    }

    override fun getLayout() = R.layout.home_fragment

    override fun initView() {
        initElements()
    }
}