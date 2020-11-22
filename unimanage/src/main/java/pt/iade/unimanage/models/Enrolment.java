package pt.iade.unimanage.models;

public class Enrolment {
    private Student student;
    private Unit unit;
    private double grade;
    public Enrolment(Student student ,
                Unit unit, double grade) {
        this.student = student;
        this.unit = unit;
        this.grade= grade;
                }
}