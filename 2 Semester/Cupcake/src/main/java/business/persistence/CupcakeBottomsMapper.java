package business.persistence;

import business.entities.CupcakeBottom;
import business.exceptions.UserException;
import web.FrontController;
import web.commands.Command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CupcakeBottomsMapper {

    public static List<CupcakeBottom> getAllCupcakeBottoms() throws UserException {
        List<CupcakeBottom> cupcakeBottomList = null;

        try {
            String sql = "SELECT * FROM cupcake_bottoms";
            Connection connection = FrontController.database.connect();
            PreparedStatement ps = connection.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (cupcakeBottomList == null) {
                    cupcakeBottomList = new ArrayList<>();
                }
                int cupcakeBottomId = rs.getInt("cupcake_bottom_id");
                String cupcakeBottomName = rs.getString("cupcake_bottom_name");
                double cupcakeBottomPrice = rs.getDouble("cupcake_bottom_price");
                CupcakeBottom cupcakeBottom = new CupcakeBottom(cupcakeBottomId, cupcakeBottomName, cupcakeBottomPrice);
                cupcakeBottomList.add(cupcakeBottom);
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return cupcakeBottomList;
    }
}
