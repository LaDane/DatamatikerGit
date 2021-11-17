package business.persistence;


import business.entities.*;

public class CupcakeCreation {

    public static Cupcake createCupcake(int cupcakeBottomId, int cupcakeTopId) {
        CupcakeBottom cupcakeBottom = null;
        CupcakeTop cupcakeTop = null;

        for (CupcakeBottom cb : CupcakeBottoms.getCupcakeBottoms()) {
            if (cb.getCupcakeBottomId() == cupcakeBottomId) {
                cupcakeBottom = cb;
            }
        }

        for (CupcakeTop ct : CupcakeTops.getCupcakeTops()) {
            if (ct.getCupcakeTopId() == cupcakeTopId) {
                cupcakeTop = ct;
            }
        }

        if (cupcakeBottom != null && cupcakeTop != null) {
            double cupcakePrice = cupcakeBottom.getCupcakeBottomPrice() + cupcakeTop.getCupcakeTopPrice();
            return new Cupcake(cupcakeBottom, cupcakeTop, cupcakePrice);
        }
        return null;
    }
}
