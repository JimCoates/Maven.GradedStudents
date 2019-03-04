package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    String grade;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
        this.grade = "A";
    }

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

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        StringBuilder allExamScores = new StringBuilder();
        int examNumber = 1;

        for(Double score : examScores){
            allExamScores.append("  Exam " + examNumber + " -> "+ score + "\n");
            examNumber++;
        }

        return allExamScores.toString();
    }

    public void addExamScore(Double scoreToAdd){
        this.examScores.add(scoreToAdd);
    }

    public void setExamScore(int examIndex, double newScore){
        examScores.set(examIndex-1, newScore);
    }

    public double getAverageExamScore(){
        return sumExamScores()/examScores.size();
    }

    public double sumExamScores(){
        Double sum = 0.0;
        for(Double score : examScores){
            sum += score;
        }

        return sum;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString(){
        StringBuilder studentInfo = new StringBuilder("");
        studentInfo.append(">Average Score:" + getAverageExamScore() +"\n");
        studentInfo.append(">Exam Scores: \n" + getExamScores());

        return studentInfo.toString();
    }


}
