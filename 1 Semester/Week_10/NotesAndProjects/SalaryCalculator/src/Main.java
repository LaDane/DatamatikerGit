public class Main {
    public static void main(String[] args) {

        Salary oleSalary = new Salary(5.50);
        Job oleJob = new Job("Bagagemand", oleSalary);
        Person ole = new Person("Ole", 99, oleJob);

        Salary bobbySalary = new Salary(7.50);
        Job bobbyJob = new Job("Pilot", bobbySalary);
        Person bobby = new Person("Bobby", 2, bobbyJob);


        System.out.println("Ole tjener dette på en måned: ");
        System.out.println(ole.job.salary.calculateMonthlySalary());
        System.out.println("Ole tjener dette på en år: ");
        System.out.println(ole.job.salary.calculateYearlySalary());

        System.out.println("Bobby tjener dette på en måned: ");
        System.out.println(bobby.job.salary.calculateMonthlySalary());
        System.out.println("Bobby tjener dette på en år: ");
        System.out.println(bobby.job.salary.calculateYearlySalary());
    }
}
