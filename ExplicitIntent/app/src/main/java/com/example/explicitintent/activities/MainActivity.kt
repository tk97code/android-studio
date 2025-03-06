package com.example.explicitintent.activities

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.explicitintent.AppConstants
import com.example.explicitintent.R
import com.example.explicitintent.showToast

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast: Button = findViewById(R.id.btnShowToast)
        val btnSendMsgToNextActivity: Button = findViewById(R.id.btnSendMsgToNextActivity)
        val btnShareToOtherApps: Button = findViewById(R.id.btnShareToOtherApps)
        val etUserMessage: EditText = findViewById(R.id.etUserMessage)

        btnShowToast.setOnClickListener{
            showToast(resources.getString(R.string.btn_was_clicked), Toast.LENGTH_LONG)
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(AppConstants.Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Please select app: "))
        }
    }
}