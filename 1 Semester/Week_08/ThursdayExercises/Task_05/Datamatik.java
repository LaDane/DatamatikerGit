public class Datamatik {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student("Jack", 25, false, "blue");
        students[1] = new Student("Marie", 10, true, "blue");
        students[2] = new Student("Fred", 50, false, "green");
        students[3] = new Student("Jen", 30, true, "green");
        students[4] = new Student("Charlie", 17, false, "yellow");
        students[5] = new Student("Gronk", 60, false, "yellow");
        students[6] = new Student("Per", 30, false, "purple");
        students[7] = new Student("Emely", 22, true, "purple");
        students[8] = new Student("Fie", 34, true, "pink");
        students[9] = new Student("ole", 80, false, "pink");

        System.out.println(indexStudent(students, 2));
        System.out.println(indexStudent(students, 5));
        System.out.println(indexStudent(students, 7));

        System.out.println(lookUpStudent(students, "Gronk"));
        System.out.println(lookUpStudent(students, "Emely"));
        System.out.println(lookUpStudent(students, "Fred"));
    }

    public static String indexStudent(Student[] s, int i) {
        return s[i].name;
    } 


    public static int lookUpStudent(Student[] s, String studentName) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].name == studentName) return i;
        }
        return -1;
    }
}






/*
For this task you should reuse the Student class from Task 3. 
    Methods of reusing the class could be: 
    - copy the Students.java file and add it to a new folder called task5
    - copy the content of the Students class from Task 3 and create the class once more in this folder
    - Open the task 3 folder and continue working in this.
    Either method is fine - it is up to you. 
    
5.a Create a new class Datamatik or reuse the one you created earlier. Add an array of Students with 10 elements in it. This should be a class variable (static). 
    From the main method, add 10 student instances to the array. Each student must have a unique reference.

5.b Create a function in Datamatik that takes in the array from 5.a as a parameter as well as an integer. 
    The function should return the field "name" (the name of the student) and print it (the integer should be used as the index number of the student to be printed). 
    Call this method with different parameters (only the integer - not the array) from the main() of Datamatik.

5.c Create a similar function to that of 5.b, but instead of receiving the array and an integer, it receives the array and a string. 
Loop through all elements in the array until you find the element with the name received as a parameter. Then return the index of that student. 
Call this method with different names from the main method of Datamatik
*/

