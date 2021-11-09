package DBAccess;

import FunctionLayer.Info;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BmiMapper {

    public static void insertBmiItem(double height, double weight, String category,
                         double bmi, String gender, int sport_id, List<String> infoList) throws LoginSampleException {
        int newId = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO bmi_entry(height, weight, category," +
                    "bmi, gender, sport_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, height);
            ps.setDouble(2, weight);
            ps.setString(3, category);
            ps.setDouble(4, bmi);
            ps.setString(5, gender);
            ps.setInt(6, sport_id);

            int result = ps.executeUpdate();
            ResultSet idResultSet = ps.getGeneratedKeys();
            if (idResultSet.next()) {
                newId = idResultSet.getInt(1);

                SQL = "INSERT INTO link_bmi_info(bmi_id, info_id) VALUES (?,?)";
                ps = con.prepareStatement(SQL);
                for (String info_id : infoList) {
                    ps.setInt(1, newId);
                    ps.setInt(2, Integer.parseInt(info_id));
                    ps.executeUpdate();
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
