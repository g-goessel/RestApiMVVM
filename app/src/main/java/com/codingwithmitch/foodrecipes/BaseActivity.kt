package com.codingwithmitch.foodrecipes

import android.app.Activity
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ProgressBar

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mProgressBar: ProgressBar

    override fun setContentView(layoutResID: Int) {

        val constraintLayout = layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout = constraintLayout.findViewById<FrameLayout>(R.id.activity_content)
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar)

        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)
    }

    fun showProgressBar(visible: Boolean) {

        mProgressBar.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }


}
