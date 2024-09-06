package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstart:Button=findViewById(R.id.btnstart)
        val etname:EditText=findViewById(R.id.etname)
        btnstart.setOnClickListener{
            if(etname.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                 val intent=Intent(this,QuizQuestionactivity::class.java) //is activity se dosari activity pe jane ke liye

                intent.putExtra(constants.USER_NAME,etname.text.toString() )
                startActivity(intent) // to start intent
                 finish() // to close the whole application
            }
        }

    }
}