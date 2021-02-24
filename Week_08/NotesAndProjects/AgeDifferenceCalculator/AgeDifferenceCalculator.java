import java.time.Period;
import java.time.LocalDate;

public class AgeDifferenceCalculator {
    public String getDifference(Period me, Period you){
        String s;

        s =  Math.abs(you.minus(me).getYears()) +" year and "+ Math.abs(you.minus(me).getMonths()) +" months and "+ Math.abs(you.minus(me).getDays()) +" days";
        return s;
    }

    public Period getAge(int year, int month, int day){
        LocalDate birthday = LocalDate.of(year,month,day);          // Get today with LocalDate.now() method
        LocalDate today = LocalDate.now();                          //Get period between birthday and today 
        Period period = Period.between(birthday, today);   
        return period;
    }
}