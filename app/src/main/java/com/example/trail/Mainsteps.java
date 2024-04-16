package com.example.trail;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mainsteps extends AppCompatActivity {// this activity to display the robot tools

    private Spinner toolspnr;// the robots tools spinner
    private ImageView toolImage; // ImageView to display the images for the robot tools
    private TextView toolDescription; // TextView to display the description of the tool
    private TextView toolSteps; // TextView to display the steps to build the robot using the selected tool

    // Array of objects containing tool name, image resource ID, and steps to build the robot
     Tool[] tools = {// make array of the tools that will show objects of tools in it each of them  will show the name ,description and the pic for each tool
            new Tool("\uD83E\uDD16 Step1: Arduino", R.drawable.arduino, "Arduino is an open-source electronics platform for building interactive projects, including robots.\n\nStep 1: Connect components\nStep 2: Write Arduino code\nStep 3: Upload code to Arduino board"),
            new Tool("\uD83E\uDD16 Step2: Raspberry Pi", R.drawable.rasberry, "Raspberry Pi is a low-cost, credit card-sized computer widely used in robotics for its powerful processing capabilities and GPIO pins.\n\nStep 1: Install Raspberry Pi OS\nStep 2: Connect peripherals\nStep 3: Write Python code"),
            new Tool("\uD83E\uDD16 Step3: ROS (Robot Operating System)", R.drawable.ros, "ROS is an open-source framework providing libraries, tools, and conventions for building robot software, simplifying the development of complex robotic systems.\n\nStep 1: Install ROS\nStep 2: Set up ROS workspace\nStep 3: Create ROS packages"),
            new Tool("\uD83E\uDD16 Step4: OpenCV (Open Source Computer Vision Library)", R.drawable.opencv, "OpenCV is a popular library for computer vision tasks such as object detection, recognition, and tracking, making it valuable for robotic applications.\n\nStep 1: Install OpenCV library\nStep 2: Write Python code for computer vision tasks"),
            new Tool("\uD83E\uDD16 Step5: ROS Navigation Stack", R.drawable.rosnav, "The ROS Navigation Stack is a set of packages for autonomous navigation in robots, providing algorithms and tools for localization, mapping, path planning, and obstacle avoidance.\n\nStep 1: Install ROS Navigation Stack\nStep 2: Configure robot sensors\nStep 3: Implement navigation algorithms"),
            new Tool("\uD83E\uDD16 Step6: See the final result!!", R.drawable.jpg, "by collecting the tools together here is the final result show me your creativity !!!"),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsteps);//conect this class java with the xml
        toolspnr = findViewById(R.id.spnCategories);//conect the xml spinner with the java spinner variable
        toolImage = findViewById(R.id.imageView); // connect the ImageView for the images with the java variable
        toolDescription = findViewById(R.id.toolDescriptionTextView); // connect the TextView for the tool description with the java variable
        toolSteps = findViewById(R.id.descriptionTextView); // connect the TextView for the steps with the java variable

        String[] tolnam = new String[tools.length];// create array that store the tool name  as its size of the tools
        for (int i = 0; i < tools.length; i++) {
            tolnam[i] = tools[i].getName();//get the names just from the  objects in array
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tolnam);// make array robotoolinner element on it addapter to put
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//the spinner layout that will shown
        toolspnr.setAdapter(adapter);// make the adapter content into the spinner
        toolspnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// listener for the selected  item from the spinner
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int i, long id) {//override method that set on action for the on item selected  from the spinner
                Tool slctol = tools[i];// here to update the image and description  for each tool selected
                updatool(slctol);// update the tool
            }@Override
            public void onNothingSelected(AdapterView<?> adapterView) {// if not selected nothing of the spinner do nothing

            }
        });
        SharedPreferences prefs = getSharedPreferences("ToolPrefs", MODE_PRIVATE);// used the shared prefrences to save the current data init
        int selectedToolIndex = prefs.getInt("selectedToolIndex", 0);// set default to 0 if not found
        toolspnr.setSelection(selectedToolIndex);// set the selected element that was it was
    }
    private void updatool(Tool slctol) {//this method used to update the selected tool for the robot
        toolImage.setImageResource(slctol.getImageResourceId());// set the image for the selected one by getting the id
        toolSteps.setText(slctol.getSteps());// set the description test that are the steps to build a robot
    }
   @Override
    protected void onStop() {// here i override the on pause method  to make the  values will be saved the question that i reach and the score too
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences("ToolPrefs", MODE_PRIVATE).edit();// used shred prefrences to save the data
        editor.putInt("selectedToolIndex", toolspnr.getSelectedItemPosition());// save the value of the spnir position
        editor.apply();// apply the edits
    }
    @Override
    protected void onSaveInstanceState(Bundle state) {// to save the data even i change the oriantation
        super.onSaveInstanceState(state);
        state.putInt("selectedToolIndex", toolspnr.getSelectedItemPosition());// here to save thestae of the selected tool index
    }
}
