package com.mirko.quizflag

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

// The on click listener is necessary for
// changing the colour while selecting an option
// Method View.OnClickListener

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Code refactoring
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUsername: String? = null
    private var mCorrectAns: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOpt1: TextView? = null
    private var tvOpt2: TextView? = null
    private var tvOpt3: TextView? = null
    private var tvOpt4: TextView? = null

    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

// here we retrieve the username passed in the main activity from the getStringExtra()
        mUsername = intent.getStringExtra(Constants.USERNAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)

        tvOpt1 = findViewById(R.id.tv_opt1)
        tvOpt2 = findViewById(R.id.tv_opt2)
        tvOpt3 = findViewById(R.id.tv_opt3)
        tvOpt4 = findViewById(R.id.tv_opt4)

        btnSubmit = findViewById(R.id.btn_submit)

        tvOpt1?.setOnClickListener(this)
        tvOpt2?.setOnClickListener(this)
        tvOpt3?.setOnClickListener(this)
        tvOpt4?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        /*
        Sets the questions on the activity layout
        */

        defaultOptionView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOpt1?.text = question.optionOne
        tvOpt2?.text = question.optionTwo
        tvOpt3?.text = question.optionThree
        tvOpt4?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size)
            btnSubmit?.text = "FINISH"
        else
            btnSubmit?.text = "SUBMIT"
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOpt1?.let {
            options.add(0, it)
        }
        tvOpt2?.let {
            options.add(1, it)
        }
        tvOpt3?.let {
            options.add(2, it)
        }
        tvOpt4?.let {
            options.add(3, it)
        }

        // set the default colour of the text view option
        // the typeface, background
        // in the loop

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_opt1 -> {
                tvOpt1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tv_opt2 -> {
                tvOpt2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_opt3 -> {
                tvOpt3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_opt4 -> {
                tvOpt4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++ // increase the current position

                    // set the questions until reach the end
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
//                            Toast.makeText(this, "You Made it!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANS, mCorrectAns)
                            intent.putExtra(Constants.TOT_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    // set the current question
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        //  set the wrong answer
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAns++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size)
                        btnSubmit?.text = "FINISH"
                    else btnSubmit?.text = "GO TO NEXT QUESTION"

                    mSelectedOptionPosition = 0 // change the position by setting to 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOpt1?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOpt2?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOpt3?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOpt4?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}