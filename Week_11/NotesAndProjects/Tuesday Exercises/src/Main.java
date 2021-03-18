public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo();

        // animals
        Cat myCat = new Cat(4);
        Cow myCow = new Cow(5);
        Fish myFish = new Fish(1);

        myZoo.addAnimal(myCat);
        myZoo.addAnimal(myCow);
        myZoo.addAnimal(myFish);

        myZoo.makeAllSounds();
        myZoo.printNumberOfLegs();
    }
}
