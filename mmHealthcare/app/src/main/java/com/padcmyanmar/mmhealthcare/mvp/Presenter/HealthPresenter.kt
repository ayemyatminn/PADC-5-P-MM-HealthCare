package com.padcmyanmar.mmhealthcare.mvp.Presenter

import android.arch.lifecycle.MutableLiveData
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO
import com.padcmyanmar.mmhealthcare.data.model.HealthModel
import com.padcmyanmar.mmhealthcare.delegates.HealthActionDelegates
import com.padcmyanmar.mmhealthcare.mvp.View.HealthView

class HealthPresenter(view:HealthView) : BasePresenter<HealthView>(view) ,HealthActionDelegates{

    private var healthModel:HealthModel?=null
    var mHealthInfoListLD:MutableLiveData<List<HealthVO>>?=null

    init {

        healthModel=HealthModel.getINSTANCE()
        mHealthInfoListLD=MutableLiveData()
        loadHealthInfo()

    }

    open fun loadHealthInfo(){
        healthModel!!.loadHealth(mHealthInfoListLD!!,mErrorLiveData)
    }

    fun getHealthList():MutableLiveData<List<HealthVO>>{
        return mHealthInfoListLD!!
    }

    fun getErrorMessage():MutableLiveData<String>?{
        return mErrorLiveData!!
    }

    override fun onTapHealthItem(url: String) {
        mView!!.displayUrl(url)
    }
}