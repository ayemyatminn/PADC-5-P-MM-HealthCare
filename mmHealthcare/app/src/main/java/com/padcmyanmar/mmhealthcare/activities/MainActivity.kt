package com.padcmyanmar.mmhealthcare.activities

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.R.id.message
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.padcmyanmar.mmhealthcare.R
import com.padcmyanmar.mmhealthcare.adapters.HealthAdapter
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO
import com.padcmyanmar.mmhealthcare.mvp.Presenter.HealthPresenter
import com.padcmyanmar.mmhealthcare.mvp.View.HealthView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , HealthView{


    private var mAdapter:HealthAdapter?=null
    private var mPresenter:HealthPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

        }
        mAdapter= HealthAdapter(applicationContext)
        rvHealthCare.adapter=mAdapter
        rvHealthCare.layoutManager=LinearLayoutManager(this)

        mPresenter= HealthPresenter(this)
        mPresenter!!.getHealthList().observe(this, Observer<List<HealthVO>> {
            response->displayHealthList(response!!)
        })
        mPresenter!!.getErrorMessage()!!.observe(this, Observer<String>{
            message->displayError(message!!)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun displayHealthList(healthList: List<HealthVO>) {
        mAdapter!!.setHealthData(healthList)
    }

    override fun displayError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
