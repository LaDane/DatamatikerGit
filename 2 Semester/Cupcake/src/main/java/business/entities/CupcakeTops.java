package business.entities;

import business.exceptions.UserException;
import business.persistence.CupcakeTopsMapper;

import java.util.List;

public class CupcakeTops {

    private static List<CupcakeTop> cupcakeTops;

    private static void initCupcakeTops() throws UserException {
        cupcakeTops = CupcakeTopsMapper.getAllCupcakeTops();
    }

    public static List<CupcakeTop> getCupcakeTops() {
        if (cupcakeTops == null) {
            try {
                initCupcakeTops();
            } catch (UserException e) {
                e.printStackTrace();
            }
        }
        return cupcakeTops;
    }
}
