package com.adityapp.quizeriya

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    //declaration + assigned/initialized to null
    private var mUserName : String? = null

    private var kt_progressBar : ProgressBar? = null
    private var kt_progressBarText : TextView? = null
    private var kt_question : TextView? = null
    private var kt_questionImage : ImageView? = null
    private var kt_option1 : TextView? = null
    private var kt_option2 : TextView? = null
    private var kt_option3 : TextView? = null
    private var kt_option4 : TextView? = null
    private var kt_btnSubmit : Button? = null

    private var mCurrentPosition: Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mCorrectAnswer : Int = 0

    private var mSelectedOptionNumber : Int = 0 // potential bug

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        //initialization
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        kt_progressBar = findViewById(R.id.progressBar)
        kt_progressBarText = findViewById(R.id.tv_progressBarText)
        kt_question = findViewById(R.id.tv_question)
        kt_questionImage = findViewById(R.id.iv_questionImage)

        kt_option1 = findViewById(R.id.tv_option1)
        kt_option2 = findViewById(R.id.tv_option2)
        kt_option3 = findViewById(R.id.tv_option3)

        kt_option4 = findViewById(R.id.tv_option4)
        kt_btnSubmit = findViewById(R.id.btnSubmit)
        mQuestionsList = Constants.getQuestions()

        kt_option1?.isEnabled = false
        kt_option2?.isEnabled = false
        kt_option3?.isEnabled = false
        kt_option4?.isEnabled = false


        getQuestion()

        // setting onClickListener or Calling OnClickMethod
        kt_option1?.setOnClickListener(this)
        kt_option2?.setOnClickListener(this)
        kt_option3?.setOnClickListener(this)
        kt_option4?.setOnClickListener(this)

        kt_btnSubmit?.setOnClickListener(this)

    }

    private fun getQuestion() {
        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionButton()

        kt_option1?.isEnabled = !(kt_option1!!.isEnabled)
        kt_option2?.isEnabled = !(kt_option2!!.isEnabled)
        kt_option3?.isEnabled = !(kt_option3!!.isEnabled)
        kt_option4?.isEnabled = !(kt_option4!!.isEnabled)

        kt_progressBar?.progress = mCurrentPosition
        kt_progressBarText?.text = "${mCurrentPosition}/${kt_progressBar?.max}"
        kt_questionImage?.setImageResource(question.image)
        kt_question?.text = question.question
        kt_option1?.text = question.optionOne
        kt_option2?.text = question.optionTwo
        kt_option3?.text = question.optionThree
        kt_option4?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList?.size){
            kt_btnSubmit?.text = "FINISH"
        }else{
            kt_btnSubmit?.text = "SUBMIT"
        }
    } //working Checked

    private fun defaultOptionButton(){
        val options = ArrayList<TextView>()

        kt_option1?.let {
            options.add(0, it)
        }
        kt_option2?.let {
            options.add(1, it)
        }
        kt_option3?.let {
            options.add(2, it)
        }
        kt_option4?.let {
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                    R.drawable.tv_background_border
                )
        }

    }

    private fun selectedOptionButton(tv : TextView, SelectedOptionNumber : Int){
        defaultOptionButton()
        mSelectedOptionNumber = SelectedOptionNumber

        tv.setTextColor(Color.BLACK)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.tv_selected_background_border
            )

    } //potential Problem : FIXED

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1 -> {
                kt_option1?.let {
                        selectedOptionButton(it, 1)
                    }
            }

            R.id.tv_option2 -> {
                kt_option2?.let {
                    selectedOptionButton(it, 2)
                }
            }

            R.id.tv_option3 -> {
                kt_option3?.let {
                    selectedOptionButton(it, 3)
                }
            }

            R.id.tv_option4 -> {
                kt_option4?.let {
                    selectedOptionButton(it, 4)
                }
            }

            R.id.btnSubmit -> {
                if(mSelectedOptionNumber == 0){
                    mCurrentPosition++

                    /*
                    *if (mCurrentPosition <= mQuestionsList!!.size){
                    *   getQuestion()
                    * below 'when' block can also be written as a 'if statement' as written above.
                    */
                when{
                    mCurrentPosition <= mQuestionsList!!.size ->{
                        getQuestion()
                    } else ->{
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        startActivity(intent)
                        finish()

                    }
                }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionNumber){
                        answerView(mSelectedOptionNumber,R.drawable.tv_wrong_background_border)
                    } else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.tv_correct_background_border)

                    kt_option1?.isEnabled = !(kt_option1!!.isEnabled)
                    kt_option2?.isEnabled = !(kt_option2!!.isEnabled)
                    kt_option3?.isEnabled = !(kt_option3!!.isEnabled)
                    kt_option4?.isEnabled = !(kt_option4!!.isEnabled)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        kt_btnSubmit?.text = "FINISH"
                    } else {
                        kt_btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionNumber = 0
                }
            }
        }
    }

    private fun answerView (answer : Int, drawAbleView: Int){
        when(answer){
            1 -> {
                kt_option1?.background = ContextCompat.getDrawable(
                    this, drawAbleView
                )
            }

            2 -> {
                kt_option2?.background = ContextCompat.getDrawable(
                    this, drawAbleView
                )
            }

            3 -> {
                kt_option3?.background = ContextCompat.getDrawable(
                    this, drawAbleView
                )
            }

            4 -> {
                kt_option4?.background = ContextCompat.getDrawable(
                    this, drawAbleView
                )
            }
        }
    }


}