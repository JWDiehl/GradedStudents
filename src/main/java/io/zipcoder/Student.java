package io.zipcoder;

import java.util.ArrayList;

public class Student {

    //    Part 1.1; Defining instance variables
    //Declare an instance variable for each of the previously mentioned properties:

    //String firstName
    private String firstName;
    //a collection of characters representative of a first name.

    //String lastName
    private String lastName;
    //a collection of characters representative of a last name.

    //ArrayList<Double> examScores
    private ArrayList<Double> examScores;
    //a dynamic collection of decimal values representative of test scores.


    //    Part 1.2; Defining construction
    //    Define a Student constructor whose parameters are used to initialize its instance variables.
    //    The Student constructor has expected parameters of
    //    String representative of a firstName
    //    String representative of a lastName
    //    Double[] representative of a collection of testScores
    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    //Generate Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    //getNumberOfExamsTaken
    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

}
