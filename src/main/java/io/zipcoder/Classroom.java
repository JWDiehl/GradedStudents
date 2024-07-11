package io.zipcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Classroom {

    //Part 2.1; Defining instance variables
    //Declare an instance variable for each of the Classroom properties:
    //Student[] students
    //a collection of student objects
    private List<Student> students;


    //Part 2.2; Defining construction
    //Define a Classroom constructor whose parameters are used to initialize its instance variable.
    // The class Classroom should support 3 different ways of being constructed.

    //The class Classroom should define a constructor which takes an argument
    // of an int representative of the maxNumberOfStudents that this Classroom can hold.
    public Classroom (int maxNumberOfStudents) {
        this.students = new ArrayList<>(maxNumberOfStudents);
        //this.students = new Student[maxNumberOfStudents];
    }

    //The class Classroom should define an additional constructor which takes an argument of
    // Student[] representative of the collection of Student objects this Classroom will store.
    //Initializing array of student objects
    public Classroom(Student[] students) {
        this.students = new ArrayList<>(List.of(students));
    }

    //The class Classroom should define a nullary constructor which initializes the composite students object to be an empty array of 30 Student objects.
    public Classroom() {
        this.students = new ArrayList<>();
        //iterate through an array of 30 students (i<30)
        for(int i = 0; i < 30; i++) {
            this.students.add(null);
        }
    }

    //Part 2.3; Defining methods
    //Define method getStudents()
    //Define a getter which returns the composite students object.

    //Generated setter and getter for students - private class from above
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = new ArrayList<>(Arrays.asList(students));
    }

    //Define method getAverageExamScore()
    //Define a getter which returns the sum of all exam averages divided by the number of students.
    public double getAverageExamScore() {
        //Make sure student is not null
        if (students.isEmpty()) {
            return 0.0;
        }

        double totalSum = 0.0;
        int totalStudents = students.size();


            //Iterate through each student then we will be able to sum and calculate average (sum of student exam scores / number of students)
            for (Student student : students) {
                //pull the average exam score from list of students
                //add the averages together
                totalSum += student.getAverageExamScore();
                //count the number of students who have taken the exam - incrementing each time through the loop
            }
            //Calculate the average using the variables we initiated earlier (avg = totalSum / totalStudents)
            return totalSum / totalStudents;
        }

    //Define method addStudent(Student student)
    //Define a method which uses a Student parameter to add a Student object to the composite students list.
    public void addStudent(Student student) {
        students.add(student);
    }

    //Define method removeStudent(String firstName, String lastName)
    //The class Classroom should define a method which uses a firstName and lastName parameter to identify and remove the respective student from composite students object.
    //Ensure the array is re-ordered after the removal; Null values should be located in the final indices of the array.
    public void removeStudent(String firstName, String lastName) {
        students.removeIf(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName));
    }

    //Define method getStudentsByScore()
    //The class Classroom should define a method getStudentsByScore() which returns an array representation of Student objects sorted in descending order by score.
    //If two students have the same class average, order them lexigraphically.
    public List<Student> getStudentsByScore() {
        //Converts the students list into a stream to perform operations
        return students.stream()
                //. sorted sorts the students based on the provided computer  -- Comparator compares students by their average exam score in descending order (highest to lowest)
                .sorted(Comparator.comparingDouble(Student::getAverageExamScore).reversed()
                        //.thenComparing compares if two students have the same average - they are further sorted lexicographically by last name and then by first name
                        .thenComparing(Student::getLastName).thenComparing(Student::getFirstName))
                //collects the sorted students from the stream into a List<student>
                .collect(Collectors.toList());
    }


    //Define method getGradeBook()
    //The class Classroom should define a method getGradeBook() which returns a mapping of Student objects to a respective letter grade determined by creating a grading curve such that
    //An A is awarded to students whose class average is in the upper 10th percentile.
    //A B is awarded to students whose class average falls between the upper 11th and 29th percentile.
    //A C is awarded to students whose class average falls between the upper 30th and 50th percentile.
    //A D is awarded to students whose class average falls between the lower 51st and 89th percentile.
    //An F is awarded to students whose class average is in the lower 11th percentile.


    //Great Book --> hash map -- to be able to associate values (name and grade) for each student
    public Map<Student, String> getGradeBook() {
        Map<Student, String> gradeBook = new HashMap<>();

        //Sort students by average exam score descending
        List<Student> sortedStudents = getStudentsByScore();

        //Determine percentiles for grades
        int totalStudents = sortedStudents.size();
        int upper10th = totalStudents / 10;
        int upper30th = totalStudents * 3 / 10;
        int upper50th = totalStudents / 2;
        int lower89th = totalStudents * 89 / 100;

        //Assign grades based on percentiles
        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            double average = student.getAverageExamScore();
            String grade;

            if(i<upper10th) {
                grade = "A";
            } else if (i < upper30th) {
                grade = "B";
            } else if (i < upper50th) {
                grade = "C";
            } else if (i < lower89th) {
                grade = "D";
            } else {
                grade = "F";
            }

            gradeBook.put(student, grade);
        }
        return gradeBook;
    }
}
