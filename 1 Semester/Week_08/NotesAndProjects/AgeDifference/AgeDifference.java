import java.time.Period;
import java.time.LocalDate;


class AgeDifference {
    public static void main(String[] args) {     
        Period  me = getAge(1974,9,3);
        Period you = getAge(1972,7,15);
        
        System.out.println("I am "+ me.getYears() +" years and "+ me.getMonths() +" months");
        System.out.println("You are "+ you.getYears() +" years and "+ you.getMonths() +" months");
        System.out.println("Age difference: "+ getDifference(me, you));    
    }

    public static String getDifference(Period me, Period you){
        String s;

        s =  Math.abs(you.minus(me).getYears()) +" year and "+ Math.abs(you.minus(me).getMonths()) +" months and "+ Math.abs(you.minus(me).getDays()) +" days";
        return s;
    }

    public static Period getAge(int year, int month, int day){
        LocalDate birthday = LocalDate.of(year,month,day);          // Get today with LocalDate.now() method
        LocalDate today = LocalDate.now();                          //Get period between birthday and today 
        Period period = Period.between(birthday, today);   
        return period;
    }
}