package com.example.trail;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainQuiz extends AppCompatActivity {// this activity class is for the quiz
    TextView total;// represents the total number of the question
    TextView question;//represents the question
    // buttons that represent the answer choices
    Button ansA;// answer as a button
    Button ansB;// answer as a button
    Button ansC;// answer as a button
    Button ansD;// answer as a button
    int counter = 0;// counter to count  my score
    int totalQ = QuizQA.question.length;// represents the total question that i have got that is in QuizQA represent the question array
    int currQIndex = 0;// counter for the current index am in or we can say in other word the question that iam in
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);// connect this java file with xml
        // her find vie by id for the varaible in this class and connected t the elemnt that are in the xml file
        total = findViewById(R.id.totalques);
        question = findViewById(R.id.question);
        ansA = findViewById(R.id.ansA);
        ansB = findViewById(R.id.ansb);
        ansC = findViewById(R.id.ansc);
        ansD = findViewById(R.id.ansd);
        total.setText("Total questions: " + totalQ);// set the text in the total text view to the total question that i have that are in the array in the QuizQA class that i implement
        if (savedInstanceState != null) {//if there is an saved instance data
            currQIndex = savedInstanceState.getInt("currQIndex", 0); // set the default value if not found
            counter = savedInstanceState.getInt("score", 0); // set the default value if not found
            uploadQ(); // resume and continue the states from the point i stopped in
        } else {// if there is no saved state or i can say instance state so i start it from the beginning
            uploadQ();
        }
    }
    private void uploadQ() {// this method is to load the question with it answer choices
        if (currQIndex != totalQ) {
            // i got the info for the question and the answers from the muckup java class that i create
            question.setText(QuizQA.question[currQIndex]);// get the first question and go on the other until they finished
            ansA.setText(QuizQA.choice[currQIndex][0]);// set the first choice for question
            ansB.setText(QuizQA.choice[currQIndex][1]);// set the second choice for question
            ansC.setText(QuizQA.choice[currQIndex][2]);// set the third choice for question
            ansD.setText(QuizQA.choice[currQIndex][3]);// set the forth choice for question

        }else{// if the total question matches the current index that iam in
            endquiz();// then finish the quiz
            return;
        }
    }
    private void endquiz() {// this method is to finish the quiz that i start by display the toast massege with score
        String status=" ";// initialize status
        if (counter > totalQ * 0.5) {// if the mark is more tham half
            status = "\uD83E\uDD16 Yahooooooo!!! u Passed";// set the status to pass
        } else {// is the mark is less than the half
            status = "\uD83E\uDD16 ooooooh noooo! you Failed you can try agian!";// set the status to failed
        }
        String message = status+"\n"+"Your Score is " + counter + " / " + totalQ;// the message content that it will display
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();// initialized toast massege to put the status on it
        new Handler().postDelayed(() -> restart(), Toast.LENGTH_LONG);// it will restart the question quiz and score after the toast runs and finish
    }
    public void selectedans(View view) {// this method is onclick handler for the answers that check if they the correct answer or not
        Button btn = (Button) view;// make the view to casting to the button
        String selectedAns = btn.getText().toString();// get the text on the button that is the answer

        if (selectedAns.equals(QuizQA.correctans[currQIndex])==true) {// check if the answer that i select is the answer that matches the correct answer

            counter++;// rise up the score counter that represents my grade out of the question number

        }

        currQIndex++;// increse the current index to go to the second question
        uploadQ();// and load the question the second question
    }
    private void restart() {// this method used to reset the quiz to start from the begining
        counter = 0;// set the counter of the quesyion to 0
        currQIndex = 0;// and return back to the first question
        uploadQ();// upload the question and its answers
    }
    @Override
    protected void onPause() {// here i override the on pause method  to make the  values will be saved the question that i reach and the score too
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("QuizPrefs", MODE_PRIVATE);// use the shared prefrences to save the data
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("currQIndex", currQIndex); // here to save the current question index
        editor.putInt("score", counter); // here to save the user's score
        editor.apply();// apply the editor prefrences
    }
    @Override
    protected void onResume() {// this method that if i return back to keep the data saved if i get back button or go to another activity
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("QuizPrefs", MODE_PRIVATE);// use the shared prefrences to save the data
        currQIndex = prefs.getInt("currQIndex", 0); // set defaolt value  to the 0 if its not found
        counter = prefs.getInt("score", 0); // set the default value to 0 if its not found
        uploadQ(); // resume and continue the quiz from the point i stoped in
    }
    @Override
    protected void onSaveInstanceState(Bundle state) {// this method is used to save the data even if i change the orientation
        super.onSaveInstanceState(state);
        state.putInt("currQIndex", currQIndex); // here to save the current question index
        state.putInt("score", counter); // here to save the score of the quiz
    }
}
