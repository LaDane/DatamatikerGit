public class Datamatik {
    public static void main(String[] args) {
        Teacher bobbyTeacher = new Teacher("Bobby", 99, false);

        Student jeffStudent = new Student("Jeff", 5, false, "Da big one");
        Student janeStudent = new Student("Jane", 12, true, "Da small one");


        System.out.println(bobbyTeacher.name+ " teacher\n");

        String jeffStr = "First student name: "+ jeffStudent.name +"\nStudent team: "+ jeffStudent.datamatikerTeam +"\n";
        System.out.println(jeffStr);

        String janeStr = "First student name: "+ janeStudent.name +"\nStudent team: "+ janeStudent.datamatikerTeam +"\n";
        System.out.println(janeStr);       
    }
}
