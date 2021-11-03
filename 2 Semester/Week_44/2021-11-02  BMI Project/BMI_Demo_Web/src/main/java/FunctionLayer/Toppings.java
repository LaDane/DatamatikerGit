package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Toppings {

    private static List<Topping> toppings;

    public static void initTopping() {
        if (toppings == null) {
            toppings = new ArrayList<>();
            // Hent toppings fra database
            toppings.add(new Topping(1, "Chocolate", 5.0));
            toppings.add(new Topping(2, "Blueberry", 8.0));
        }
    }

    public static List<Topping> getToppings() {
        return toppings;
    }
}
