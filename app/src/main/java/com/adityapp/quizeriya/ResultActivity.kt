package com.adityapp.quizeriya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val kt_UserName: TextView = findViewById(R.id.tv_userName)
        val kt_score : TextView = findViewById(R.id.tv_score)
        val ktBtnFinish : Button = findViewById(R.id.btnFinalFinish)

        kt_UserName.text = intent.getStringExtra(Constants.USER_NAME)
        val resScore = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val resTotalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        kt_score.text = ("You have Scored $resScore OUT OF $resTotalQuestion")
        ktBtnFinish.setOnClickListener {
            val finishIntent = Intent(this, MainActivity::class.java)
            startActivity(finishIntent)
            finish()
        }
    }

}