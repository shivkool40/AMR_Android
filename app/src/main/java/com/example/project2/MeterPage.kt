package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_meter_page.*

class MeterPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meter_page)

        Room101.setOnClickListener {
            val popup = PopupMenu(this, Room101)
            popup.inflate(R.menu.testpopup)
            val cam = Intent(this, camera2::class.java)
            val man = Intent(this, Manual2::class.java)
            popup.setOnMenuItemClickListener{item ->
                when(item.itemId) {
                    R.id.camera -> startActivity(cam)
                    R.id.manual ->startActivity(man)
                }
                true

            }
            popup.show()
        }
    }
}
