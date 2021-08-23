import java.time.Period;
// import java.time.LocalDate;


class Main {
    public static void main(String[] args) {     
        AgeDifferenceCalculator ageDifferenceCalculator = new AgeDifferenceCalculator();

        Period  me = ageDifferenceCalculator.getAge(1974,9,3);
        Period you = ageDifferenceCalculator.getAge(1972,7,15);
        
        System.out.println("I am "+ me.getYears() +" years and "+ me.getMonths() +" months");
        System.out.println("You are "+ you.getYears() +" years and "+ you.getMonths() +" months");
        System.out.println("Age difference: "+ ageDifferenceCalculator.getDifference(me, you));    
    }
}

