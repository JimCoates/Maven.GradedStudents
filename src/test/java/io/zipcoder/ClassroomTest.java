package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class ClassroomTest {

  //  Classroom classroom;

    @Test
    public void getAverageClassExamScore() {
        // : Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Double expected = 125.0;

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students =  {s1, s2} ;
        Classroom classroom = new Classroom(students);

        // When
        Double output = classroom.getAverageClassExamScore();

        // Then
        Assert.assertEquals(expected,output);
    }


    @Test
    public void addStudentTest(){
        Classroom classroom = new Classroom(0);
        Double[] scores = {121.0,126.0,90.0};
        Student student = new Student("Jim", "C", scores);
        Student student1 = new Student("Davis", "P", scores);

        Student[] preEnrolled = classroom.getStudents();
        classroom.addStudent(student);
        classroom.addStudent(student1);
        Student[] postEnrolled = classroom.getStudents();

        Integer preEnrollString = preEnrolled.length;
        Integer postEnrollString = postEnrolled.length;

        Assert.assertNotEquals(preEnrollString,postEnrollString);
        System.out.println(postEnrollString);
        System.out.println(preEnrollString);

    }

    @Test
    public void removeFirstandLastNameTest(){

        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Double[] s3Scores = {89.0, 99.0};
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);

        Student[] students = {s1, s2, s3};

        Classroom classroom = new Classroom(students);

        String beforeRemoval = classroom.getStudents().toString();
        classroom.removeFirstAndLastName("student","two");
        String afterRemoval = classroom.getStudents().toString();

        System.out.println(beforeRemoval);
        System.out.println(afterRemoval);
    }

    @Test
    public void getStudentByScoreTest(){

        Double[] s1Scores = {100.0, 101.0};
        Double[] s2Scores = {225.0, 224.0};
        Double[] s3Scores = {89.0, 99.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);

        Student[] students = {s1, s2, s3};

        Classroom classroom = new Classroom(students);

        Student[] actual = classroom.getStudentByScore();
        Student[] expected = {s3,s1,s2};

        Assert.assertEquals(expected[0], actual[0]);

    }

    @Test
    public void getGradeBookTest(){
        Double[] s1Scores = {100.0, 101.0};
        Double[] s2Scores = {225.0, 224.0};
        Double[] s3Scores = {109.0, 99.0};
        Double[] s4Scores = {140.0, 141.0};
        Double[] s5Scores = {299.0, 224.0};
        Double[] s6Scores = {188.0, 129.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);
        Student s5 = new Student("student", "five", s5Scores);
        Student s6 = new Student("student", "six", s6Scores);

        Student[] students = {s1, s2, s3, s4, s5, s6};

        Classroom classroom = new Classroom(students);

        TreeMap<String,Student> grades = classroom.getGradeBook();

        for (String grade : grades.keySet()) {
            String student = grades.get(grade).getLastName();
            System.out.println(grade + " " + student);
        }
    }
}
