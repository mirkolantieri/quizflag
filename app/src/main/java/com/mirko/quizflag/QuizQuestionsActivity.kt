package com.mirko.quizflag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOpt1: TextView? = null
    private var tvOpt2: TextView? = null
    private var tvOpt3: TextView? = null
    private var tvOpt4: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)

        tvOpt1 = findViewById(R.id.tv_opt1)
        tvOpt2 = findViewById(R.id.tv_opt2)
        tvOpt3 = findViewById(R.id.tv_opt3)
        tvOpt4 = findViewById(R.id.tv_opt4)


        val questionList = Constants.getQuestions()
        Log.i("Question List size is", "${questionList.size}")

        for (qst in questionList){
            Log.e("Questions", qst.question)
        }

        var currentPosition = 1
        val question: Question = questionList[currentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOpt1?.text = question.optionOne
        tvOpt2?.text = question.optionTwo
        tvOpt3?.text = question.optionThree
        tvOpt4?.text = question.optionFour

    }
}