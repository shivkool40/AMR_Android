package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.whenCreated
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_meter_page.*

class MeterPage : AppCompatActivity() {

    /*********************************** Global Varibles ************************************************************/

    var read101LastMeterValue: String = ""
    var read101Id: Int = 0
    var read102LastMeterValue: String = ""
    var read102Id: Int = 0
    var read103LastMeterValue: String = ""
    var read103Id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meter_page)

        /***********************************  FireBase ************************************************************/

//     read101
        val database = FirebaseDatabase.getInstance()
        val myRef101 = database.reference.child("101")
        myRef101.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                var map = p0.value as Map<String, Any>
                Room101Before.text = map["LastMeterValue"].toString()
                Room101latest.text = map["CurrentMeterValue"].toString()
                Room101Useage.text = map["Useage"].toString()

                read101LastMeterValue = map["LastMeterValue"].toString()
                read101Id = map["Id"].toString()!!.toInt()

            }
        })

//     read102
        val myRef102 = database.reference.child("102")
        myRef102.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                var map = p0.value as Map<String, Any>
                Room102Before.text = map["LastMeterValue"].toString()
                Room102latest.text = map["CurrentMeterValue"].toString()
                Room102Useage.text = map["Useage"].toString()

                read102LastMeterValue = map["LastMeterValue"].toString()
                read102Id = map["Id"].toString()!!.toInt()

            }
        })

//     read103
        val myRef103 = database.reference.child("103")
        myRef103.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                var map = p0.value as Map<String, Any>
                Room103Before.text = map["LastMeterValue"].toString()
                Room103latest.text = map["CurrentMeterValue"].toString()
                Room103Useage.text = map["Useage"].toString()

                read103LastMeterValue = map["LastMeterValue"].toString()
                read103Id = map["Id"].toString()!!.toInt()

            }
        })
    }

    /*********************************** Intent and dataPassing ************************************************************/
    fun customOnClick(it: View) {
        when(it.id) {

            R.id.Room101 -> {
                val popup = PopupMenu(this, Room101)
                popup.inflate(R.menu.testpopup)
                val cam = Intent(this, camera2::class.java)

                val man = Intent(this, Manual2::class.java)
                man.putExtra("key", "101")
                man.putExtra("LastMeterValue", read101LastMeterValue)
                man.putExtra("Id", read101Id)

                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.camera -> startActivity(cam)
                        R.id.manual -> startActivity(man)

                    }
                    true

                }
                popup.show()

            }
            R.id.Room102 -> {
                val popup = PopupMenu(this, Room102)
                popup.inflate(R.menu.testpopup)

                val cam2 = Intent(this, camera2::class.java)


                val man2 = Intent(this, Manual2::class.java)
                man2.putExtra("key", "102")
                man2.putExtra("LastMeterValue", this.read102LastMeterValue)
                man2.putExtra("Id", read102Id)

                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.camera -> startActivity(cam2)
                        R.id.manual -> startActivity(man2)
                    }
                    true

                }
                popup.show()
            }


            R.id.Room103 -> {
                val popup = PopupMenu(this, Room103)
                popup.inflate(R.menu.testpopup)

                val cam3 = Intent(this, camera2::class.java)


                val man3 = Intent(this, Manual2::class.java)
                man3.putExtra("key", "103")
                man3.putExtra("LastMeterValue", this.read103LastMeterValue)
                man3.putExtra("Id", read103Id)

                popup.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.camera -> startActivity(cam3)
                        R.id.manual -> startActivity(man3)
                    }
                    true

                }
                popup.show()
            }

            }
        }
}

