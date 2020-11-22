package pt.iade.unimanage.models;
import java.time.LocalDate;


public class StudentRepository {
    private static ArrayList<Student> students =
                                new ArrayList<Student>();
    public static void populate() {
        Student s; // auxiliary variable
        s = new Student("John",LocalDate.parse("2000-05-24"),'M');
        s.setEmail("john@gmail.com");
        students.add(s);
        students.add(new Student("Mary",LocalDate.parse("1999-12-23"),'F'));
        s = new Student("James",LocalDate.parse("2001-07-02"),'M');
        students.add(s);
    }  
    public static List<Student> getStudents() {
        return students;
    } 
    public static Student getStudent(int number) {
        for (Student student: students)
            if (student.getNumber() == number)
                return student;
        return null;
    } 
    public static boolean deleteStudent(int number){
        return student.removeIf(
                        (s)-> s.getNumber()==number);
    }
    public static Student addStudent(Student student) {
        students.add(student);
        return student;
    }
}