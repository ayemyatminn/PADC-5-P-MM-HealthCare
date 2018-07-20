package com.padcmyanmar.mmhealthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO
import com.padcmyanmar.mmhealthcare.delegates.HealthActionDelegates
import kotlinx.android.synthetic.main.view_item_healths.view.*

class HealthViewHolder(itemView: View,private val delegate:HealthActionDelegates):BaseViewHolder<HealthVO>(itemView) {
    private var data:HealthVO?=null
    override fun setData(data: HealthVO) {
        this.data=data


        Glide.with(itemView.ivAuthorImage)
                .load(data.author!!.authorImage)
                .into(itemView.ivAuthorImage)

        itemView.tvAuthorName.text=data.author!!.authorName
        itemView.tvPublishDate.text=data.healthPublishDate
        itemView.tvHealthTitle.text=data.healthTitle
        Glide.with(itemView.ivHealthImage)
                .load(data.healthImage)
                .into(itemView.ivHealthImage)

        itemView.tvHealthBrief.text=data.healthShortDescription

        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        delegate.onTapHealthItem(data!!.completeUrl!!)
    }
}