package com.padcmyanmar.mmhealthcare.mvp.Presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.padcmyanmar.mmhealthcare.mvp.View.BaseView

abstract class BasePresenter<V:BaseView>(view: V):ViewModel() {

    protected var mView: V? = view
    protected var mErrorLiveData: MutableLiveData<String>? = null

    init {
        mErrorLiveData = MutableLiveData()
    }

}