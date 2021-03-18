public class Main {
    public static void main(String[] args) {
        Account[] myAccounts = new Account[3];

        myAccounts[0] = new Account("1/5/09 11:37","Product1",1200,"Visa",4234120954489197l,
                "Janet","Ottawa","Ontario","Canada","1/5/099:35","1/5/09 19:24",
                "45.4166667","-75.7");
        myAccounts[1] = new Account("1/5/09 20:00","Product2",3600,"Visa",4904344348439820l,
                "James","Burpengary","Queensland","Australia","12/10/08 19:53","1/8/09 17:58",
                "-27.1666667","152.95");
        myAccounts[2] = new Account("1/3/09 13:24","Product1",1200,"Visa",4737470823565213l,
                "Mehmet Fatih","Helsingor","Frederiksborg","Denmark","1/3/09 12:47","1/9/09 11:14",
                "56.0333333","12.6166667");
        
        System.out.println(myAccounts[0].toString());
    }
}
