package com.mirko.quizflag

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

        val btnStart: Button = findViewById(R.id.btn_start)
        val etName: EditText = findViewById(R.id.et_name)

//      Set the event listener when the
//      button is being clicked
        btnStart.setOnClickListener {
            if(etName.text.isEmpty()){
                Toast.makeText(this, "Please enter your name to" +
                        " continue", Toast.LENGTH_LONG).show()

            } else {
            /*
            * Create an intent here in order to access
            * the new page where it will contain the next activity layout
            * */
                val intent: Intent = Intent(this, QuizQuestionsActivity::class.java)
                startActivity(intent)
//              finish() - here the method can close the app once the activity is completed
            }

        }
    }


}