package web.commands;

import business.entities.OrderEntry;
import business.entities.User;
import business.exceptions.UserException;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerViewOrderCommand extends CommandProtectedPage{
    public CustomerViewOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("viewOrderId") != null) {
            HttpSession session = request.getSession();
            List<OrderEntry> customerOrders = null;
            int orderId = Integer.parseInt(request.getParameter("viewOrderId"));
            String username = "";

            try (Connection connection = FrontController.database.connect()) {
                String sql = "SELECT users_user_id, cupcake_bot, cupcake_top, amount FROM orders WHERE order_id=?";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, orderId);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        if (customerOrders == null) {
                            customerOrders = new ArrayList<>();
                        }

                        int users_user_id = rs.getInt("users_user_id");
                        int cupcake_bot = rs.getInt("cupcake_bot");
                        int cupcake_top = rs.getInt("cupcake_top");
                        int cupcake_amount = rs.getInt("amount");

                        OrderEntry orderEntry = new OrderEntry(orderId, users_user_id, cupcake_bot, cupcake_top, cupcake_amount);
                        customerOrders.add(orderEntry);

                        username = orderEntry.getOrderEntryUsername();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            session.setAttribute("orderEntryUsername", username);
            session.setAttribute("customerOrders", customerOrders);

        }
        return pageToShow;
    }

}
