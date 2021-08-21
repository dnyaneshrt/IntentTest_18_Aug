package com.tech.intenttest18_aug

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            intent.putExtra("my_name", name)//putExtra is used to send string type of data to anather actvity
            startActivity(intent)

        }

        btn_linkedin.setOnClickListener {

           try {

               var intent=packageManager.getLaunchIntentForPackage("com.linkedin.android")
               startActivity(intent)
           }catch(e: Exception)
           {
               Toast.makeText(this,e.localizedMessage,Toast.LENGTH_SHORT).show()
               //to take user to play store

               var intent=Intent()
               intent.setAction(Intent.ACTION_VIEW)
               intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.jio.bapp"))
               startActivity(intent)

           }

        }

        btn_browser.setOnClickListener {

            var url=et_url.text.toString()
            var intent=Intent()
            intent.setAction(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)


        }

        btn_myjio.setOnClickListener {
            var intent=packageManager.getLaunchIntentForPackage("com.jio.myjio")
            startActivity(intent)
        }
    }
}