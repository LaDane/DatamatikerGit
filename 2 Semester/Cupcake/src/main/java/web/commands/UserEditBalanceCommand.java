package web.commands;

import business.entities.User;
import business.persistence.UserMapper;
import business.services.UserFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserEditBalanceCommand extends CommandProtectedPage{

    public UserEditBalanceCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        int userId = Integer.parseInt(request.getParameter("userId"));
        double newUserBalance = Double.parseDouble(request.getParameter("newUserBalance"));

        UserFacade userFacade = new UserFacade(FrontController.database);
        List<User> allUsers = userFacade.getAllUsers();
        User user = null;
        for (User allUser : allUsers) {
            if (allUser.getId() == userId) {
                user = allUser;
            }
        }

        User userSession = (User) session.getAttribute("user");
        if (userSession.getId() == user.getId()) {
            userSession.setBalance(newUserBalance);
            session.setAttribute("user", userSession);
        }

        if (user != null) {
            user.setBalance(newUserBalance);

            try (Connection connection = FrontController.database.connect()) {
                String sql = "UPDATE users SET balance=? WHERE user_id=?";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setDouble(1, newUserBalance);
                    ps.setInt(2, userId);
                    ps.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        session.setAttribute("viewUser", user);

        return pageToShow;
    }
}
