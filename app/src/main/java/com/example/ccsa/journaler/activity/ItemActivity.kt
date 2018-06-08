package com.example.ccsa.journaler.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.ccsa.journaler.R
import com.example.ccsa.journaler.model.MODE
import kotlinx.android.synthetic.main.activity_header.view.*

abstract class ItemActivity : BaseActivity() {

    protected var mode = MODE.VIEW
    protected var success = Activity.RESULT_CANCELED

    override fun getActivityTitle() = R.string.app_name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.extras
        data?.let{
            val modeToSet = data.getInt(MODE.EXTRAS_KEY, MODE.VIEW.mode)
            mode = MODE.getByValue(modeToSet)
        }
        Log.v(tag, "Mode [ $mode ]")
    }

    override fun onDestroy() {
        super.onDestroy()
        setResult(success)
    }
}