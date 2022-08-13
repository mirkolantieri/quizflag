package com.mirko.quizflag

/* Here is defined the class model
* necessary for the condition and/or
* other option/s available within the view.
* The parameters define the behaviour of this class
* */

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
