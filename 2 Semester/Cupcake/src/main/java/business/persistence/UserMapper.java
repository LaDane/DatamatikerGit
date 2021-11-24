package business.persistence;

import business.exceptions.UserException;
import business.entities.User;
import web.FrontController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException {
        try (Connection connection = FrontController.database.connect()) {
            String sql = "SELECT user_id, role, balance FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("user_id");
                    double balance = rs.getDouble("balance");
                    User user = new User(email, password, role, balance);
                    user.setId(id);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    private static void printOutAllUsers() {
        try {
            String sql = "SELECT * FROM users";
            Connection connection = FrontController.database.connect();
            PreparedStatement ps = connection.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println("email: "+ email + " - password: "+ password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<User> getAllUsers() {
        List<User> users = null;
        try {
            String sql = "SELECT * FROM users";
            Connection connection = FrontController.database.connect();
            PreparedStatement ps = connection.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (users == null) {
                    users = new ArrayList<>();
                }
                int userId = rs.getInt("user_id");
                String username = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                double balance = rs.getDouble("balance");
                users.add(new User(userId, username, password, role, balance));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
