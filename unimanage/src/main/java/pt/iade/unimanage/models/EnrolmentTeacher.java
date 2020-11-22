package pt.iade.unimanage.models;

public class EnrolmentTeacher {
    private Teacher teacher;
    private Unit unit;
    public Enrolment(Teacher teacher ,
                Unit unit) {
        this.teacher = teacher;
        this.unit = unit;
                }
}