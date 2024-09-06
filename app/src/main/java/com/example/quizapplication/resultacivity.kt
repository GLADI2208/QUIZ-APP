package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultacivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultacivity)

        val tvname:TextView=findViewById(R.id.tv_name)
        val tvscore:TextView=findViewById(R.id.tv_score)
        val tvfinish:Button=findViewById(R.id.btn_finish)
        tvname.text=intent.getStringExtra(constants.USER_NAME)

        val totalquestion=intent.getIntExtra(constants.Total_question,0)
        val correctanswer=intent.getIntExtra(constants.Correct_answer,0)
        tvscore.text="Your score is $correctanswer out of $totalquestion"
        tvfinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}