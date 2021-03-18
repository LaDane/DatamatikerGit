package AnimalExamples;

public class Main
{

    public static void main(String[] args)
    {
        // write your code here


        Cat myCat = new Cat();
        myCat.meow();

        Animal myCat2 = new Cat();
        myCat2.printName();

        //cast to subtype and store it in a subtype variable
        Cat myCatAfterCast = (Cat) myCat2;
        //now we can call functions in the subclass!
        myCatAfterCast.meow();

        //inline version does both steps in one line
        ((Cat)myCat2).meow();

    }
}
