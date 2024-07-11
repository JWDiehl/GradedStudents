package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    private Student student;

    @Before
    public void setup() {
        //initialize a new student objects before each test
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(85.0, 90.0, 88.0));
        student = new Student("Stevie", "Van Buren", examScores);
    }

    @Test
    public void testConstructor() {
        //Given
        String expectedFirstName = "Stevie";
        String expectedLastName = "Van Buren";

        //When
        ArrayList<Double> examScores = new ArrayList<>();
        Student student = new Student(expectedFirstName, expectedLastName, examScores);

        //Then
        Assert.assertEquals(expectedFirstName, student.getFirstName());
        Assert.assertEquals(expectedLastName, student.getLastName());
//        Assert.assertEquals(examScores, student.getExamScores());
    }

    @Test
    public void testGetAverageExamScore() {
        //Given
        double expectedAverage = (85.0 + 90.0 + 88.0) / 3.0;

        //When
        double actualAverage = student.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAverage, actualAverage, 0.01);
    }

    @Test
    public void testAddExamScore() {
        //Given
        double newExamScore = 95.0;

        //When
        student.addExamScore(newExamScore);

        //Then
        Assert.assertEquals(4, student.getExamScores().size());
        Assert.assertEquals(newExamScore, student.getExamScores().get(3), 0.01);
    }

    @Test
    public void testSetExamScore() {
        //Given
        ArrayList<Double> newExamScores = new ArrayList<>(Arrays.asList(95.0, 92.0, 88.0, 90.0));

        //When
        student.setExamScores(newExamScores);

        //Then
        Assert.assertEquals(newExamScores, student.getExamScores());
    }

    @Test
    public void testToString() {
        //Given
        String expectedString = "Student Name: Stevie Van Buren\n" +
                                "> Average Score: 87\n" +
                                "> Exam Scores:\n" +
                                "ExamScores:\n" +
                                "\tExam1 -> 85.0\n" +
                                "\tExam2 -> 90.0\n" +
                                "\tExam3 -> 88.0\n";

        //When
        String actualString = student.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }
}