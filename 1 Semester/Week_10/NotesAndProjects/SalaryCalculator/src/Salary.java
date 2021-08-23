public class Salary {
    double dailyEarings;

    public Salary(double dailyEarings) {
        this.dailyEarings = dailyEarings;
    }

    public double calculateMonthlySalary() {
        double monthlyEarning = dailyEarings * 30;
        return monthlyEarning;
    }

    public double calculateYearlySalary() {
        double yearlyEarings = calculateMonthlySalary() * 12;
        return yearlyEarings;
    }
}
