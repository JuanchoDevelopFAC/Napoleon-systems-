package com.example.napoleonsystemsapp.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.napoleonsystemsapp.R
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getDatos()

        val actionBar = supportActionBar
        actionBar!!.title = "Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun getDatos() {
        val bundle = intent.extras
        val titleReceived = bundle?.get("INTENT_TITLE")
        val bodyReceived = bundle?.get("INTENT_BODY")
        detail_title.text = titleReceived.toString()
        detail_body.text = bodyReceived.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}