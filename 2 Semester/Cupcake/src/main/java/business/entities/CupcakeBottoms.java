package business.entities;

import business.exceptions.UserException;
import business.persistence.CupcakeBottomsMapper;

import java.util.List;

public class CupcakeBottoms {

    private static List<CupcakeBottom> cupcakeBottoms;

    private static void initCupcakeBottoms() throws UserException {
        cupcakeBottoms = CupcakeBottomsMapper.getAllCupcakeBottoms();
    }

    public static List<CupcakeBottom> getCupcakeBottoms() {
        if (cupcakeBottoms == null) {
            try {
                initCupcakeBottoms();
            } catch (UserException e) {
                e.printStackTrace();
            }
        }
        return cupcakeBottoms;
    }
}
