package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_manual2.*

class Manual2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual2)

        var intent = intent

        var id = intent.getIntExtra("Id",1)
        var key = intent.getStringExtra("key")
        var BeforeMeter = intent.getStringExtra("LastMeterValue")
        var intBeforeMeter = BeforeMeter.toInt()



        /************* FireBase ****************************************************************************************/


        val database = FirebaseDatabase.getInstance()

        SaveBtn.setOnClickListener {
            val inputString = inputMan.text.toString()
            var userInput = if (inputString.isNotEmpty()) inputString.toInt() else 0

            var currentUseage = (userInput - intBeforeMeter)*7

            database.reference.child(key).child("CurrentMeterValue").setValue(userInput)
            database.reference.child(key).child("Useage").setValue(currentUseage)



        }

    }
}
