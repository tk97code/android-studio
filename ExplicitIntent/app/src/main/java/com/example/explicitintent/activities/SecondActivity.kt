package com.example.explicitintent.activities

import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.explicitintent.AppConstants
import com.example.explicitintent.R
import com.example.explicitintent.showToast

class SecondActivity: AppCompatActivity() {
    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe Call   ?.
        // Safe Call with let  ?.let {  }

        val bundle: Bundle? = intent.extras
        val txvUserMessage: TextView = findViewById(R.id.txvUserMessage)

        bundle?.let {
            val msg = bundle.getString(AppConstants.Constants.USER_MSG_KEY)
            showToast(msg+"")
            txvUserMessage.text = msg
        }
    }

}