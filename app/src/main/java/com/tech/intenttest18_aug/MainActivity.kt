package com.tech.intenttest18_aug

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //dial screen will open
        btn_dail.setOnClickListener {

            var mobile_number = et_mobile_number.text.toString()
            var intent = Intent()
            intent.setAction(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${mobile_number}")
            startActivity(intent)

        }

        //next activity will be open after clicking on next button
        btn_next.setOnClickListener {

            var name = et_name.text.toString()
            var intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("my_name", name)
            startActivity(intent)

        }

        btn_linkedin.setOnClickListener {

        }
    }
}