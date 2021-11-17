package web.commands;

import business.entities.OrderEntry;
import business.entities.OrderEntryCombined;
import business.entities.User;
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
            List<OrderEntryCombined> customerOrderEntriesCombined = new ArrayList<>();
            long lastOrderId = 0;

            for (OrderEntry customerOrderEntry : customerOrderEntries) {
                if (lastOrderId != customerOrderEntry.getOrderEntryId()) {
                    lastOrderId = customerOrderEntry.getOrderEntryId();

                    customerOrderEntriesCombined.add(new OrderEntryCombined(
                            customerOrderEntry.getOrderEntryId(),
                            customerOrderEntry.getOrderEntryCupcakeAmount(),
                            customerOrderEntry.getOrderEntryTotal()
                    ));
                } else {
                    for (OrderEntryCombined orderEntryCombined : customerOrderEntriesCombined) {
                        if (orderEntryCombined.getOrderId() == lastOrderId) {
                            orderEntryCombined.setOrderCupcakeAmount(orderEntryCombined.getOrderCupcakeAmount() + customerOrderEntry.getOrderEntryCupcakeAmount());
                            orderEntryCombined.setOrderPrice(orderEntryCombined.getOrderPrice() + customerOrderEntry.getOrderEntryTotal());
                        }
                    }
                }
            }
            session.setAttribute("orderEntriesCombined", customerOrderEntriesCombined);
        }

        return pageToShow;
    }
}
