package com.mirko.quizflag

/* The constants object is needed
* to access the data from the model Question.
* Here are stored constant objects such as:
* username, amount of questions, correct answers etc.
* Tip: here the getQuestions are hardcoded in this object file
* but can easily be accessed with JSON or API calls from an
* online service.
*  */

object Constants {

    const val USERNAME: String = "username"
    const val TOT_QUESTIONS: String = "total questions"
    const val CORRECT_ANS: String = "Correct answers"


    fun getQuestions(): ArrayList<Question> {
//        this method returns an ArrayList of
//        Question(s) which are created as list
//        within the same method.

        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_albania,
            "Albania", "Australia",
            "Turkey", "Spain",
            1
        )
        val que2 = Question(
            2, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_germany,
            "Netherlands", "Belgium",
            "Germany", "Denmark",
            3
        )

        val que3 = Question(
            3, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_france,
            "Spain", "Italy",
            "Germany", "France",
            4
        )
        val que4 = Question(
            4, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_italy,
            "Switzerland", "Italy",
            "Greece", "France",
            2
        )

        val que5 = Question(
            5, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_sweden,
            "Norway", "Finland",
            "Sweden", "Russia",
            3
        )

        val que6 = Question(
            6, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_uk,
            "United Kingdom", "Ireland",
            "Scotland", "England",
            1
        )

        val que7 = Question(
            7, "Which of these countries does belong the shown flag?",
            R.drawable.ic_flag_usa,
            "Canada", "United States of America",
            "Mexico", "Cuba",
            2
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)

        return questionsList
    }
}