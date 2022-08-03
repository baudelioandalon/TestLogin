package com.baudelio.test.macropay.ui

import com.baudelio.test.core.utils.base.CUBaseActivity
import com.baudelio.test.macropay.R
import com.baudelio.test.macropay.databinding.ActivityMainBinding

class MainActivity : CUBaseActivity<ActivityMainBinding>() {

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        initElements()
    }

}