package io.zipcoder;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Classroom {
    Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }


    public Double getAverageClassExamScore() {
        Double sumOfExamScores = 0.0;
        int numberOfExams = 0;

        for (Student student : students) {
            sumOfExamScores += student.sumExamScores();
            numberOfExams += student.getNumberOfExamsTaken();
        }

        return sumOfExamScores / numberOfExams;
    }

    public void addStudent(Student student) {
        Student[] temp = Arrays.copyOf(this.students, this.students.length + 1);
        temp[temp.length - 1] = student;

        this.students = temp;

    }

    public void removeFirstAndLastName(String firstName, String lastName) {

        ArrayList<Student> temp = new ArrayList<>(Arrays.asList(this.students));

        for (Student kid : temp) {
            if (kid.getFirstName().equals(firstName) && kid.getLastName().equals(lastName)) {
                temp.remove(kid);
            }
        }
        Student[] answer = temp.toArray(new Student[temp.size()]);
        this.students = answer;


    }

    public Student[] getStudentByScore() {
        int n = this.students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getAverageExamScore() > students[j + 1].getAverageExamScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        return this.students;
    }

    public TreeMap<String, Student> getGradeBook() {
        getStudentByScore();
        TreeMap<String, Student> grades = new TreeMap<>();

        for (int i = 0; i < this.students.length; i++) {
            int percentile = (int) Math.abs(100 * (i - .5)) / students.length;

            if (percentile >= 90) {
                grades.put("A", students[i]);
            } else if (percentile >= 71 && percentile <= 89) {
                grades.put("B", students[i]);
            } else if (percentile >= 50 && percentile <= 70) {
                grades.put("C", students[i]);
            } else if (percentile >= 11 && percentile <= 49) {
                grades.put("D", students[i]);
            } else if (percentile <= 10.9){
                grades.put("F", students[i]);
            }
        }

        return grades;
    }
}
