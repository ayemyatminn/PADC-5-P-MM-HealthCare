package com.padcmyanmar.mmhealthcare.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.padcmyanmar.mmhealthcare.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T,W>(context:Context) : RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var mData:List<W>?=null
    protected var mlayoutInflater : LayoutInflater

    val item:List<W>
    get(){
        val data=mData
        return data?:ArrayList()
    }

    init{
        mData=ArrayList()
        mlayoutInflater= LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {
        holder.setData(mData!![position])
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    fun setHealthData(healthData: List<W>) {
        mData = healthData
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData!!.size - 1) mData!![position] else null

    }

    fun clearData() {
        mData = java.util.ArrayList()
        notifyDataSetChanged()
    }
}