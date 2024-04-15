package com.example.trail;

public class QuizQA {// this class represent as the muckup data base for the questions and the answer that will contains in the quiz activity
    public static String question[] = {// this array of string represents the questions
            "\uD83E\uDD16 What is Arduino?",
            "\uD83E\uDD16 What is Raspberry Pi?",
            "\uD83E\uDD16 What is ROS?",
            "\uD83E\uDD16 What is OpenCV?"
    };

    public static String choice[][] = {//two dimentional array that represents the answers for the questions and for each question multiple answer
            {"A microcontroller platform", "A programming language", "A type of sensor", "An operating system"},
            {"A small computer used in robotics", "A type of motor", "A programming language", "A programming framework"},
            {"An open-source framework for building robot software", "A type of sensor", "A communication protocol", "An operating system"},
            {"A library for computer vision tasks", "A type of motor controller", "A type of battery", "A microcontroller platform"}
    };

    public static String correctans[] = {// this array represents the correct answers for the question that i provided above
            "A microcontroller platform",
            "A small computer used in robotics",
            "An open-source framework for building robot software",
            "A library for computer vision tasks"
    };



}
