package io.zipcoder;

public class Classroom {

    //Part 2.1; Defining instance variables
    //Declare an instance variable for each of the Classroom properties:
    //Student[] students
    //a collection of student objects
    private Student[] students;

    //Part 2.2; Defining construction
    //Define a Classroom constructor whose parameters are used to initalize its instance variable.
    // The class Classroom should support 3 different ways of being constructed.

    //The class Classroom should define a constructor which takes an argument
    // of an int representative of the maxNumberOfStudents that this Classroom can hold.
    public Classroom (int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    //The class Classroom should define an additional constructor which takes an argument of
    // Student[] representative of the collection of Student objects this Classroom will store.
    //Initializing array of student objects
    public Classroom(Student[] students) {
        this.students = students;
    }

    //The class Classroom should define a nullary constructor which
    // initializes the composite students object to be an empty array of 30 Student objects.
    public Classroom() {
        this.students = new Student[30];
    }

    //Part 2.3; Defining methods
    //Define method getStudents()
    //Define a getter which returns the composite students object.

    //Generated setter and getter for students - private class from above
    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    //Define method getAverageExamScore()
    //Define a getter which returns the sum of all exam averages divided by the number of students.
    public double getAverageExamScore() {
        double totalSum = 0;
        int totalExams = 0;

        //Iterate through each student then we will be able to sum and calculate average (sum of student exam scores / number of exams)
        for (Student student : students) {
            //pull the average exam score from list of students
            double studentAverage = student.getAverageExamScore();
            //add the averages together
            totalSum += studentAverage;
            //count the number of students who have taken the exam - incrementing each time through the loop
            totalExams++;
        }
        //Calculate the average using the variables we initiated earlier (avg = totalSum / totalExams)
        return totalSum / totalExams;
    }

    //Define method addStudent(Student student)
    //Define a method which uses a Student parameter to add a Student object to the composite students list.


}
