package com.padcmyanmar.mmhealthcare.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.mmhealthcare.R
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO
import com.padcmyanmar.mmhealthcare.viewholders.BaseViewHolder
import com.padcmyanmar.mmhealthcare.viewholders.HealthViewHolder

class HealthAdapter(context: Context):BaseRecyclerAdapter<HealthViewHolder,HealthVO> (context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {
        val healthViewItem=mlayoutInflater.inflate(R.layout.view_item_healths,parent,false)
        return HealthViewHolder(healthViewItem)
    }


}