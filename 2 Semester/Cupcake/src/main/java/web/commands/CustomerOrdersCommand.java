package web.commands;

import business.entities.OrderEntry;
import business.entities.OrderEntryCombined;
import business.entities.User;
import business.persistence.OrderCombinedMapper;
import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrdersCommand extends CommandProtectedPage{

    public CustomerOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();

        List<OrderEntry> customerOrderEntries = OrderMapper.getOrderEntriesByUserId(userId);

        if (customerOrderEntries != null) {
            List<OrderEntryCombined> customerOrderEntriesCombined = OrderCombinedMapper.getOrderEntryCombined(customerOrderEntries);
            session.setAttribute("orderEntriesCombined", customerOrderEntriesCombined);
        }

        return pageToShow;
    }
}
