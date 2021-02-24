class Main{
    public static boolean happy = true;
  
    public static void main(String [] args) {
        if (iAmHappy()) {
            System.out.println("I clap my hands");
        } else {
            System.out.println("I don't clap my hands"); 
        }

        System.out.println(add2(2, 2));

        System.out.println(capitalizeTxt("This is capitalized"));

        String str = "Start with big letter";
        if (isFirstCapital(str)) System.out.println("First letter is capitalized");
        else System.out.println("First letter is NOT capitalized");
        
    }
  
  
    public static boolean iAmHappy() {
    // fill out what is missing here: 
        if (happy) return true;
        else return false;
    }


    public static int add2(int a, int b) {
        a += b;
        return a;
    }


    public static String capitalizeTxt(String txt) {
        return txt.toUpperCase();
    }


    public static boolean isFirstCapital(String txt) {
        char firstLetter = txt.charAt(0);
        // System.out.println(firstLetter);
        if (Character.isUpperCase(firstLetter)) return true;
        else return false;
    }
}