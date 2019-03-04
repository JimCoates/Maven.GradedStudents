package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getExamScoreTest() {
        // : Given
        String firstName = "Jim";
        String lastName = "C";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        StringBuilder sb = new StringBuilder();

        // When
        String output = student.getExamScores();
        sb.append("  Exam 1 -> 100.0\n");
        sb.append("  Exam 2 -> 95.0\n");
        sb.append("  Exam 3 -> 123.0\n");
        sb.append("  Exam 4 -> 96.0\n");

        String expected = sb.toString();


        // Then
        System.out.println(output);
        System.out.println(expected);
        Assert.assertEquals(expected, output);

    }

    @Test
    public void addExamScoreTest() {
        // : Given
        String firstName = "Jim";
        String lastName = "C";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "  Exam 1 -> 100.0\n";

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void setExamScore() {
        // : Given
        String firstName = "Jim";
        String lastName = "C";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);
        String expected = "  Exam 1 -> 150.0\n";

        // When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        // Then

        Assert.assertEquals(expected, output);
    }

    @Test
    public void getAverageExamScore() {
        // : Given
        String firstName = "Jim";
        String lastName = "C";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);
        Double expected = 125.0;

        // When
        Double output = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test


    public void toStringTest() {
        // : Given
        String firstName = "Jim";
        String lastName = "C";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);
        StringBuilder sb = new StringBuilder();


        // When
        String output = student.toString();
        sb.append(">Average Score:125.0\n");
        sb.append(">Exam Scores: \n");
        sb.append("  Exam 1 -> 100.0\n");
        sb.append("  Exam 2 -> 150.0\n");
        sb.append("  Exam 3 -> 250.0\n");
        sb.append("  Exam 4 -> 0.0\n");

        String expected = sb.toString();
        // Then
        Assert.assertEquals(expected, output);
    }


}