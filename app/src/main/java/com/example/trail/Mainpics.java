package com.example.trail;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Mainpics extends AppCompatActivity {// this activity to display the robot tools

    private Spinner toolspnr;// the robots tools spinner
    private ImageView toolImage; // ImageView to display the images for the robot tools

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpics);//conect this class java with the xml
        toolspnr = findViewById(R.id.spnCategories);//conect the xml spinner with the java spinner variable
        toolImage = findViewById(R.id.imageView); // connect the ImageView for the images with the java variable

        final String[] robotool = {"\uD83E\uDD16 Arduino", "\uD83E\uDD16 Raspberry Pi", "\uD83E\uDD16 ROS (Robot Operating System)", "\uD83E\uDD16 OpenCV (Open Source Computer Vision Library)", "\uD83E\uDD16 ROS Navigation Stack"};        // implement the robots tools in array of stng

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, robotool);// make array robotoolinner element on it addapter to put
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//the spinner layout that will shown
        toolspnr.setAdapter(adapter);// make the adapter content into the spinner

        toolspnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// listener for the selected  item from the spinner
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int i, long id) {// for the spinner i tem that will the user be selected
                String selitem = robotool[i];//update the image based on the selected i tem from the spinner
                updateImage(selitem);// update the image item
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {// if i dont select none  of them then do nth this method by default be implemented
            }
        });
    }
    private void updateImage(String tname) {// this method is to update the image for each robot tool
        int src; // the id for the pic for each tool

        if (tname.equals("\uD83E\uDD16 Arduino")==true) {// if the selected item is arduino

            src = R.drawable.arduino; // return the arduino pic

        } else if (tname.equals("\uD83E\uDD16 Raspberry Pi")==true) {// if the selected item is  rasberry pi

            src = R.drawable.rasberry; // return the rasberry pi pic

        } else if (tname.equals("\uD83E\uDD16 ROS (Robot Operating System)")==true) {// if the selected item is ROS

            src = R.drawable.ros; // return the ROS pic

        } else if (tname.equals("\uD83E\uDD16 OpenCV (Open Source Computer Vision Library)")==true) {// if the selected item is OpenCV

            src = R.drawable.opencv; // return the OpenCV pic

        } else if (tname.equals("\uD83E\uDD16 ROS Navigation Stack")==true) {// if the selected item is ROS navigation

            src = R.drawable.rosnav; // return the ROS navigation pic

        } else {
            return; // default: return nothing
        }
        toolImage.setImageResource(src); // Set the image resource to the ImageView
    }
}
