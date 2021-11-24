package business.persistence;

import business.entities.CupcakeTop;
import business.exceptions.UserException;
import web.FrontController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeTopsMapper {

    public static List<CupcakeTop> getAllCupcakeTops() throws UserException {
        List<CupcakeTop> cupcakeTopList = null;

        try {
            String sql = "SELECT * FROM cupcake_tops";
            Connection connection = FrontController.database.connect();
            PreparedStatement ps = connection.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (cupcakeTopList == null) {
                    cupcakeTopList = new ArrayList<>();
                }
                int cupcakeTopId = rs.getInt("cupcake_top_id");
                String cupcakeTopName = rs.getString("cupcake_top_name");
                double cupcakeTopPrice = rs.getDouble("cupcake_top_price");
                CupcakeTop cupcakeTop = new CupcakeTop(cupcakeTopId, cupcakeTopName, cupcakeTopPrice);
                cupcakeTopList.add(cupcakeTop);
            }

        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return cupcakeTopList;
    }
}
