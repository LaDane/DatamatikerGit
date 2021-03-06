import com.sun.jdi.request.ClassUnloadRequest;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Address
        Address oleAddress = new Address("Ole vej", 99, "1th", 999, "DK");
        Address gokAddress = new Address("Gok vej", 9, "3th", 89, "DK");

        // Teacher
        Person teacher1 = new Teacher("Ole", 99, oleAddress);
        Teacher castTeacher1 = (Teacher) teacher1;
        System.out.println(castTeacher1.age);

        // Students
        ArrayList<Student> sem1Students = new ArrayList<Student>();
        sem1Students.add(new Student("Bobby", 5, oleAddress));
        sem1Students.add(new Student("Gok", 7, gokAddress));

        // School
        Semester firstSemester = new Semester("Semester1", castTeacher1, sem1Students);
        School thisSchool = new School("DataSchool", firstSemester);

        System.out.println(sem1Students.size());

        teacher1.eat();
    }
}
