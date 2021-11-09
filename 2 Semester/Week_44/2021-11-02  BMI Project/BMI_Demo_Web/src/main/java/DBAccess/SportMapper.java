package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportMapper {

    public static List<Sport> getAllSports() throws LoginSampleException {
        List<Sport> sportList = null;

        try {
            String SQL = "SELECT * FROM sport";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement( SQL );

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                if (sportList == null) {
                    sportList = new ArrayList<>();
                }
                int sport_id = rs.getInt( "sport_id" );
                String name = rs.getString( "name" );
                Sport sport = new Sport( sport_id, name );
                sportList.add(sport);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
        return sportList;
    }
}
