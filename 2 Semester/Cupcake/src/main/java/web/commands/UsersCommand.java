package web.commands;

import business.entities.User;
import business.services.UserFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UsersCommand extends CommandProtectedPage{

    public UsersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserFacade userFacade = new UserFacade(FrontController.database);
        List<User> allUsers = userFacade.getAllUsers();

        session.setAttribute("allUsers", allUsers);
        return pageToShow;
    }
}
