package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionactivity : AppCompatActivity(), View.OnClickListener{
   private var mCurrentpos:Int=1
    private var mQuestionlist:ArrayList<question>?=null
    private var mselectedoptionpos:Int=0
    private var musername:String?=null
    private var mcorrectanswer:Int=0
    private var PB:ProgressBar?=null
    private var TVP:TextView?=null
    private var tvquestion:TextView?=null
    private var ivimage:ImageView?=null

    private var tvoptionone:TextView?=null
    private var tvoptiontwo:TextView?=null
    private var tvoptionthree:TextView?=null
    private var tvoptionfour:TextView?=null
    private var btnsubmit:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questionactivity)
         musername=intent.getStringExtra(constants.USER_NAME)
        PB=findViewById(R.id.progressbar) // progress bar
        TVP=findViewById(R.id.tv_progress)
        tvquestion=findViewById(R.id.tv_question)
        ivimage=findViewById(R.id.iv_image)
        tvoptionone=findViewById(R.id.tv_option_1)
        tvoptiontwo=findViewById(R.id.tv_option_2)
        tvoptionthree=findViewById(R.id.tv_option_3)
        tvoptionfour=findViewById(R.id.tv_option_4)
        btnsubmit=findViewById(R.id.btn_submit)



         mQuestionlist = constants.getquestions()
        setquestion()
        tvoptionone?.setOnClickListener(this)
        tvoptiontwo?.setOnClickListener(this)
        tvoptionthree?.setOnClickListener(this)
        tvoptionfour?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)

    }

    private fun setquestion() {
        defaultOptionview()
        val ques: question = mQuestionlist!![mCurrentpos  - 1]
        ivimage?.setImageResource(ques.image)
        PB?.progress = mCurrentpos
        TVP?.text = "$mCurrentpos /${PB?.max}"
        tvquestion?.text = ques.question
        tvoptionone?.text = ques.optionone
        tvoptiontwo?.text = ques.optiontwo
        tvoptionthree?.text = ques.optionthree
        tvoptionfour?.text = ques.optionfour
        ivimage?.setImageResource(ques.image)
         if(mCurrentpos==mQuestionlist!!.size){
             btnsubmit?.text="FINISH"
         }
        else{
            btnsubmit?.text="SUBMIT"
         }
    }
    private fun defaultOptionview(){
        val options=ArrayList<TextView>()
        tvoptionone?.let{
            options.add(0,it)
        }
        tvoptiontwo?.let{
            options.add(1,it)
        }
        tvoptionthree?.let{
            options.add(2,it)
        }
        tvoptionfour?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionnum:Int){
        defaultOptionview()
        mselectedoptionpos=selectedOptionnum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option
        )
    }




    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_1->{
                tvoptionone?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_2->{
                tvoptiontwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_3->{
                tvoptionthree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_4->{
                tvoptionfour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                   if(mselectedoptionpos==0){
                       mCurrentpos++
                       when{
                           mCurrentpos<=mQuestionlist!!.size->{
                               setquestion()
                           }
                           else->{
                               val intent =Intent(this,resultacivity::class.java)
                               intent.putExtra(constants.USER_NAME,musername)
                               intent.putExtra(constants.Correct_answer,mcorrectanswer)
                               intent.putExtra(constants.Total_question,mQuestionlist?.size)
                               startActivity(intent)
                               finish()
                           }
                       }
                   }else{
                       val question=mQuestionlist?.get(mCurrentpos-1)
                       if(question!!.correctanswer!=mselectedoptionpos) {
                           answerView(mselectedoptionpos, R.drawable.wrong_option)
                       }else{
                           mcorrectanswer++
                       }
                       answerView(question.correctanswer,R.drawable.correct_option)
                       if(mCurrentpos==mQuestionlist!!.size){
                           btnsubmit?.text="FINISH"
                       }else{
                           btnsubmit?.text="GO TO NEXT QUESTION"
                       }
                       mselectedoptionpos=0
                   }
            }
        }
    }
    private  fun answerView(answer:Int ,drawableview:Int){
        when(answer){
            1->{
                tvoptionone?.background=ContextCompat.getDrawable(
                    this@QuizQuestionactivity,
                    drawableview
                )
            }
            2->{
                tvoptiontwo?.background=ContextCompat.getDrawable(
                    this@QuizQuestionactivity,
                    drawableview
                )
            }
            3->{
                tvoptionthree?.background=ContextCompat.getDrawable(
                    this@QuizQuestionactivity,
                    drawableview
                )
            }
            4->{
                tvoptionfour?.background=ContextCompat.getDrawable(
                    this@QuizQuestionactivity,
                    drawableview
                )
            }
        }
    }
}