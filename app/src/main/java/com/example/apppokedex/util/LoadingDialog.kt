package com.example.apppokedex.util

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import com.example.apppokedex.R

class LoadingDialog(val mActivity: Activity) {
    private lateinit var isDialog: AlertDialog
    fun startLoading(){

        val inflater = mActivity.layoutInflater

        val dialogView = inflater.inflate(R.layout.activity_loading, null)

        val builde = AlertDialog.Builder(mActivity)
        builde.setView(dialogView)
        builde.setCancelable(false)
        isDialog = builde.create()
        isDialog.show()
    }

    fun isDismiss(){
        isDialog.dismiss()
    }
}