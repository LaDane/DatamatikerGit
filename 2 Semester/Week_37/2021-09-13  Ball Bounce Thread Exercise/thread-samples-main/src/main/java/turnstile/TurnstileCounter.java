package turnstile;

public class TurnstileCounter {

    long count = 0;

    public long getValue() {
        return count;
    }

    public void incr() {
        //Se info below, if the final result always is 40000
        count++;
    }
}
/*
   If the program initially "never" fails, replace the count line above with the lines below
    long n = count;
    //Spend some time to force preemtion -- This is called Busy-waiting - NEVER do this for real
    for(long a=0; a<10000; a++);
    n = n + 1;
    count = n;
*/