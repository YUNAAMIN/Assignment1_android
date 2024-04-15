package com.example.trail;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Mainlist extends AppCompatActivity {// this activity is to list out the conteeent of my app
    ListView listView;// list view that will contains the content of my app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lists);//connect the xml file with this java class
        listView = findViewById(R.id.listview);// connect the xml list vie with th ejava variable

        List<String> list = new ArrayList<>();// create array list of the content and add it to it
        list.add("\uD83E\uDD16 Meet Teacher!");// section for the course teacher
        list.add("\uD83E\uDD16 Robots Tools (Description)");// section for the descritpion explanation for robots tools
        list.add("\uD83E\uDD16 Robots Tools (Pictures)");// section for the picture explanation for robots tools
        list.add("\uD83E\uDD16 Lets build robot together!!");// section for the descritpion explanation for building robots using tools
        list.add("\uD83E\uDD16 Quick revision");// section for the game as quiz to refreash the info that the student will learn

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);// ccreate array addapter to put the list content onn it
        listView.setAdapter(arrayAdapter);// list view content on it

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {// click listener on the list view content
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {//if i clicked on the teacher item
                    Intent intent = new Intent(Mainlist.this, MainWho.class);// intent to move to the next activity
                    startActivity(intent);
                } else if (i == 1) {// if i clicked on the robots tools discription item
                    Intent intent1 = new Intent(Mainlist.this, SecondActivity.class);// intent to move to the next activity
                    startActivity(intent1);
                } else if (i == 2) {// if i clicked on the robots tools pics tools item
                    Intent intent2 = new Intent(Mainlist.this, Mainpics.class);// intent to move to the next activity
                    startActivity(intent2);
                } else if (i == 3) {// if i clicked on the robots building  steps tools item
                    Intent intent3 = new Intent(Mainlist.this, Mainsteps.class);// intent to move to the next activity
                    startActivity(intent3);
                } else {// if clicked on the quiz practice item
                    Intent intent4 = new Intent(Mainlist.this, MainQuiz.class);// intent to move to the next activity
                    startActivity(intent4);
                }
            }
        });

    }
}