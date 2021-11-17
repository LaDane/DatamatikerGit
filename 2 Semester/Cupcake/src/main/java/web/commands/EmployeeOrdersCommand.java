package web.commands;

import business.entities.OrderEntry;
import business.entities.OrderEntryCombined;
import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOrdersCommand extends CommandProtectedPage{

    public EmployeeOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<OrderEntry> orderEntries = OrderMapper.getAllOrderEntries();

        if (orderEntries != null) {
            List<OrderEntryCombined> orderEntriesCombined = new ArrayList<>();
            long lastOrderId = 0;

            for (OrderEntry orderEntry : orderEntries) {
                if (lastOrderId != orderEntry.getOrderEntryId()) {
                    lastOrderId = orderEntry.getOrderEntryId();

                    orderEntriesCombined.add(new OrderEntryCombined(
                            orderEntry.getOrderEntryId(),
                            orderEntry.getOrderEntryCupcakeAmount(),
                            orderEntry.getOrderEntryTotal(),
                            orderEntry.getOrderEntryUsername()
                    ));
                } else {
                    for (OrderEntryCombined orderEntryCombined : orderEntriesCombined) {
                        if (orderEntryCombined.getOrderId() == lastOrderId) {
                            orderEntryCombined.setOrderCupcakeAmount(orderEntryCombined.getOrderCupcakeAmount() + orderEntry.getOrderEntryCupcakeAmount());
                            orderEntryCombined.setOrderPrice(orderEntryCombined.getOrderPrice() + orderEntry.getOrderEntryTotal());
                        }
                    }
                }
            }
            session.setAttribute("orderEntriesCombined", orderEntriesCombined);

        }

        return pageToShow;
    }
}
