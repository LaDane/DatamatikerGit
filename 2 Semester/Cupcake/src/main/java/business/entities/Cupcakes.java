package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Cupcakes {

    private List<Cupcake> cupcakes = new ArrayList<>();

    public Cupcakes(List<Cupcake> cupcakes) {
        this.cupcakes = cupcakes;
    }

    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public void setCupcakes(List<Cupcake> cupcakes) {
        this.cupcakes = cupcakes;
    }
}
