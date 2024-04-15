package com.example.trail;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {// this classs is ti show me a description for each robotics tools
    private Spinner toolspnr;// the robots tools spinner
    private TextView descriptions; // tols decription for the robots tools

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_course);//conect this class java with the xml
        toolspnr = findViewById(R.id.spnCategories);//conect the xml spinner with the java spinner variable
        descriptions = findViewById(R.id.area);// conect the text view for the description xml with the java variael

        final String[] robotool = {"\uD83E\uDD16 Arduino", "\uD83E\uDD16 Raspberry Pi", "\uD83E\uDD16 ROS (Robot Operating System)", "\uD83E\uDD16 OpenCV (Open Source Computer Vision Library)", "\uD83E\uDD16 ROS Navigation Stack"};        // implement the robots tools in array of stng

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, robotool);// make array robotoolinner element on it addapter to put
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//the spinner layout that will shown
        toolspnr.setAdapter(adapter);// make the adapter content into the spinner

        toolspnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// listener for the selected  item from the spinner
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int i, long id) {
                String selectedItem = robotool[i];//update the description based on the selected i tem from the spinner
                updatedsc(selectedItem);// here to update the description written for each tool
            }@Override
            public void onNothingSelected(AdapterView<?> adapterView) {// if not selected nothing of the spinner do nothing
            }
        });
    }

    private void updatedsc(String selectedItem) {// this method is to update the description for each robot tool
        String desc = "description";// initalize the value for the description

        if (selectedItem.equals("\uD83E\uDD16 Arduino")==true) {// if the selected item is arduino

            desc = "Arduino is an open-source electronics platform for building interactive projects, including robots.";

        } else if (selectedItem.equals("\uD83E\uDD16 Raspberry Pi")==true) {// if the selected item is rasberry pi

            desc = "Raspberry Pi is a low-cost, credit card-sized computer widely used in robotics for its powerful processing capabilities and GPIO pins.";

        } else if (selectedItem.equals("\uD83E\uDD16 ROS (Robot Operating System)")==true) {// if the selected item is ROS

            desc = "ROS is an open-source framework providing libraries, tools, and conventions for building robot software, simplifying the development of complex robotic systems.";

        } else if (selectedItem.equals("\uD83E\uDD16 OpenCV (Open Source Computer Vision Library)")==true) {// if the selected item is OpenCV

            desc = "OpenCV is a popular library for computer vision tasks such as object detection, recognition, and tracking, making it valuable for robotic applications.";

        } else if (selectedItem.equals("\uD83E\uDD16 ROS Navigation Stack")==true) {// if the selected item is ROS navigator
            desc = "The ROS Navigation Stack is a set of packages for autonomous navigation in robots, providing algorithms and tools for localization, mapping, path planning, and obstacle avoidance.";

        }
        descriptions.setText(desc);// put the description on the text view
    }
}
