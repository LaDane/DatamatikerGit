package web.commands;

import business.entities.OrderEntryCombined;
import web.FrontController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRemoveCommand extends CommandProtectedPage{

    public OrderRemoveCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("removeOrderId") != null) {
            HttpSession session = request.getSession();
            int removeOrderId = Integer.parseInt(request.getParameter("removeOrderId"));
            boolean removeSucces = false;

            try (Connection connection = FrontController.database.connect()) {
                String sql = "DELETE FROM orders WHERE order_id IN (?)";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, Math.toIntExact(removeOrderId));
                    ps.executeUpdate();
                    removeSucces = true;
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

            if (removeSucces) {
                List<OrderEntryCombined> orderEntriesCombined = (List<OrderEntryCombined>) session.getAttribute("orderEntriesCombined");
                List<OrderEntryCombined> orderEntriesCombinedToRemove = new ArrayList<>();
                if (orderEntriesCombined != null) {
                    for (OrderEntryCombined orderEntryCombined : orderEntriesCombined) {
                        if (orderEntryCombined.getOrderId() == removeOrderId) {
                            orderEntriesCombinedToRemove.add(orderEntryCombined);
                        }
                    }
                    orderEntriesCombined.removeAll(orderEntriesCombinedToRemove);
                }
                session.setAttribute("orderEntriesCombined", orderEntriesCombined);
            }
        }

        return pageToShow;
    }
}
