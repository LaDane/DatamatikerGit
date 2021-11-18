package web.commands;

import business.entities.OrderEntry;
import business.entities.OrderEntryCombined;
import business.entities.User;
import business.persistence.OrderCombinedMapper;
import business.persistence.OrderMapper;
import business.services.UserFacade;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserViewCommand extends CommandProtectedPage{

    public UserViewCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserFacade userFacade = new UserFacade(FrontController.database);
        List<User> allUsers = userFacade.getAllUsers();

        Object userId = request.getParameter("viewUserId");
        int viewUserId = 0;
        User user = null;

        if (userId != null) {
            viewUserId = Integer.parseInt(request.getParameter("viewUserId"));
        } else {
            user = (User) session.getAttribute("user");
            viewUserId = user.getId();
        }

        if (user == null) {
            for (User aUser : allUsers) {
                if (aUser.getId() == viewUserId) {
                    user = aUser;
                    break;
                }
            }
        }

        session.setAttribute("viewUser", null);
        session.setAttribute("orderEntriesCombined", null);

        if (user != null) {
            session.setAttribute("viewUser", user);

            List<OrderEntry> customerOrderEntries = OrderMapper.getOrderEntriesByUserId(user.getId());

            if (customerOrderEntries != null) {
                List<OrderEntryCombined> customerOrderEntriesCombined = OrderCombinedMapper.getOrderEntryCombined(customerOrderEntries);
                session.setAttribute("orderEntriesCombined", customerOrderEntriesCombined);
            }
        }
        return pageToShow;
    }
}
