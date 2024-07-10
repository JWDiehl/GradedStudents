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

    //getNumberOfExamsTaken
    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    //Define method getExamScores()
    //Student should define a method which returns a string representation of all exams taken.
    public String getExamScores() {
        //String builder
        StringBuilder sb = new StringBuilder();
        //Header -> per sample output on readme
        sb.append("Exam Scores:\n");

        //Iterate over exam scores and append to StringBuilder
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("\tExam ").append(i + 1).append(" -> ").append(examScores.get(i)).append("\n");

        }
        //Convert String Builder to string and return
        return sb.toString();
    }

    //Define method addExamScore(double examScore)
    //Student should define a method named addExamScore which uses a double parameter to add an examScore to its composite List examScores.
    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    //Define method setExamScore(int examNumber, double newScore)
    //Student should define a method named setExamScore
    //which uses an int parameter to identify an exam in the list, and a double parameter to re-assign the respective value.
    public void setExamScore(int examNumber, double newScore) {
        //Check if exam number is between 1 and size of list of examScores
        if (examNumber >= 1 && examNumber <= examScores.size()) {
            //ArrayList starts at 0 - therefore we need to update the examNumber to start at one
            examScores.set(examNumber - 1, newScore);
        }
    }

    //Define method getAverageExamScore()
    //Student should define a method named getAverageExamScore() which returns the sum of the examScore list divided by its size.
    public double getAverageExamScore() {

        //Initialize a sum data point
        double sum = 0.0;

        //iterate through the examScores and add to sum
        for (double score : examScores) {
            sum += score;
        }

        //Average will be sum of scores / number of total exams
        return sum / examScores.size();
    }

    //Define method toString()
    //Student should override the toString method by returning a clean String representation of the person.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("> Average Score: ").append((int) getAverageExamScore()).append("\n");
        sb.append("> Exam Scores:\n");


        //Append the detailed exam scores
        sb.append(getExamScores());

        return sb.toString();

    }

}
