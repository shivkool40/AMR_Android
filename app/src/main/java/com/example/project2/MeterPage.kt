package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_meter_page.*

class MeterPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meter_page)


        /*********************************** Start Of FireBase ************************************************************/

//     read101
        val database =FirebaseDatabase.getInstance()
        val myRef101 = database.reference.child("101")
                myRef101.addValueEventListener(object :ValueEventListener{
                    override fun onCancelled(p0: DatabaseError) {
                    }
                    override fun onDataChange(p0: DataSnapshot) {
                        var map = p0.value as Map<String,Any>
                        Room101Before.text = map["LastMeterValue"].toString()
                        Room101latest.text = map["CurrentMeterValue"].toString()

                        var read101LastMeterValue = map["LastMeterValue"].toString()

                    }
                })

        val myRef102 = database.reference.child("102")
        myRef102.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                var map = p0.value as Map<String,Any>
                Room102Before.text = map["LastMeterValue"].toString()
                Room102latest.text = map["CurrentMeterValue"].toString()

            }
        })

        val myRef103 = database.reference.child("103")
        myRef103.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                var map = p0.value as Map<String,Any>
                Room103Before.text = map["LastMeterValue"].toString()
                Room103latest.text = map["CurrentMeterValue"].toString()

            }
        })



        /*********************************** End Of FireBase ************************************************************/



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
