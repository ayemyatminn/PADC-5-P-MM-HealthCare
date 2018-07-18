package com.padcmyanmar.mmhealthcare.data.model

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO
import com.padcmyanmar.mmhealthcare.networks.responses.GetHealthResponse
import com.padcmyanmar.mmhealthcare.utils.AppConstance
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HealthModel(context: Context):BaseModel(context) {

    companion object {
        private var INSTANCE:HealthModel?=null
        fun getINSTANCE():HealthModel{
            if (INSTANCE==null) {
                throw RuntimeException("Health Model is being initialized.")
            }
            var i= INSTANCE
            return i!!
        }
        fun initHealthModel(context: Context){
            INSTANCE= HealthModel(context)
        }
    }

    fun loadHealth(mHealthListLD:MutableLiveData<List<HealthVO>>?, mErrorLiveData: MutableLiveData<String>?) {
        mAPI!!.loadHealth(AppConstance.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthResponse> {
                    override fun onComplete() {

                    }

                    override fun onNext(response: GetHealthResponse) {
                        if (response.getHealthList() != null && response.getHealthList()!!.isNotEmpty())
                            mHealthListLD!!.value=response.getHealthList()
                    }

                    override fun onError(e: Throwable) {
                        mErrorLiveData!!.value = e.message
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                })
    }


}