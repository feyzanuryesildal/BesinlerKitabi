package com.example.mvvm_with_retrofit.utils

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm_with_retrofit.R

lateinit var alertDialog: AlertDialog


fun AppCompatActivity.showLoading() {

    val alertDialogBuilder = AlertDialog.Builder(this)
    alertDialogBuilder.setView(R.layout.alert_dialog)
    alertDialogBuilder.setCancelable(false)
    alertDialog = alertDialogBuilder.create()
    alertDialog.window?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.black, null)))
    alertDialog.show()
}

fun AppCompatActivity.hideLoading() {
    alertDialog.dismiss()
}