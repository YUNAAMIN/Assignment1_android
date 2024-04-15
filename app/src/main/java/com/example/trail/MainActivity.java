package com.example.trail;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {// this is the main activity that represent the main page for the app
    public static final String NAME = "NAME";// final value of the user id thet will save in it as a constant value
    public static final String PASS = "PASS";//final value of the password id that will save in it as a constant value
    public static final String FLAG = "FLAG";//flag representt the final value true or false ans a string
    private boolean flag = false;// boolean flag true or false and here initialied as false
    private EditText idtxt;//edit text for the student id here ill put it my id that is=1211524
    private EditText passtxt;//edit text for the student account password that is =123
    private Button logbtn;// log in button to log in to the next activity to the student account
    private SharedPreferences prefs;//allows the user to save and require data in the form of keys and values and provides a simple method to read and write them
    private SharedPreferences.Editor editor;// that make help to edit we can say make it able to write
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// connect this class with the xml
        // here to connect the xml component with the java variable
        idtxt = findViewById(R.id.user);
        passtxt = findViewById(R.id.password);
        logbtn = findViewById(R.id.btn_input);

        setupSharedPrefs();// set up the shared prefrences
        checkPrefs();// check the prefrences values
    }
    private void checkPrefs() {// this method is used to check the prefrences
        flag = prefs.getBoolean(FLAG, false);// initialize the value as a false

        if(flag==true){// if the flag is true
            String name = prefs.getString(NAME, "");
            String password = prefs.getString(PASS, "");
            idtxt.setText(name);// set the text to the id that is in final value
            passtxt.setText(password);//set the text to the password that is in final value
        }
    }
    private void setupSharedPrefs() {// this method used  to set up the shared prefrences
        prefs= PreferenceManager.getDefaultSharedPreferences(this);// make the maneger of the prefrences set on this classs
        editor = prefs.edit();// make editable can edit
    }

    private void login() {// this method that will check the id and password and if they are not empty then go to the next activity
        String id = idtxt.getText().toString().trim();// get the student id as a string
        String password = passtxt.getText().toString().trim();// get the student password as a string

        if(!flag) {// if the flag is equals to false
            editor.putString(NAME, id);// set the id the id that i enter
            editor.putString(PASS, password);// set the password the id that i enter
            editor.putBoolean(FLAG, true);// set the flag to true value
            editor.commit();
        }
        if (id.equals("1211524")==true && password.equals("123")==true) {//check if the student is is 1211524 and the password is 123
            Intent intent = new Intent(MainActivity.this, Mainlist.class);// intent to connect tow activity
            startActivity(intent);// start activate the second activity
            finish(); // finish the main activity so when i go back it make it not come back
        } else {// if its not correct or forgot to fill something it will desplay a toast massage
            Toast.makeText(MainActivity.this, "\uD83E\uDD16 Invalid user ID or password,plz check!", Toast.LENGTH_SHORT).show();// this is the toast massage that gonne displayed out
        }
    }
    public void btnclick(View view) {// event handeler to button start whn it clic do the log in method content
        login();
    }
}