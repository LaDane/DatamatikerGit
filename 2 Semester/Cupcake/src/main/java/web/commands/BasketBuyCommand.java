package web.commands;

import business.entities.BasketItem;
import business.entities.OrderEntry;
import business.entities.User;
import business.persistence.OrderMapper;
import web.FrontController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class BasketBuyCommand extends CommandProtectedPage{


    public BasketBuyCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketItems");
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        long orderId = createUniqueId();
        double orderTotal = 0;

        if (basketItems != null) {
            for (BasketItem basketItem : basketItems) {
                orderTotal += basketItem.getTotal();
                OrderEntry orderEntry = new OrderEntry(
                        orderId,
                        userId,
                        basketItem.getCupcakeBottomId(),
                        basketItem.getCupcakeTopId(),
                        basketItem.getAmount());

                try (Connection connection = FrontController.database.connect()) {
                    String sql = "INSERT INTO orders (order_id, users_user_id, cupcake_bot, cupcake_top, amount) VALUES (?, ?, ?, ?, ?)";

                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        ps.setInt(1, Math.toIntExact(orderEntry.getOrderEntryId()));
                        ps.setInt(2, orderEntry.getOrderEntryUserId());
                        ps.setInt(3, orderEntry.getOrderEntryCupcakeBot());
                        ps.setInt(4, orderEntry.getOrderEntryCupcakeTop());
                        ps.setInt(5, orderEntry.getOrderEntryCupcakeAmount());
                        ps.executeUpdate();
                    }
                    catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        session.setAttribute("basketItems", null);
        user.setBalance(user.getBalance() - orderTotal);

        try (Connection connection = FrontController.database.connect()) {
            String sql = "UPDATE users SET balance=? WHERE user_id=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, user.getBalance());
                ps.setInt(2, userId);
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        session.setAttribute("lastOrder", OrderMapper.getOrderEntriesByOrderId(orderId));
        session.setAttribute("lastOrderId", orderId);

        return pageToShow;
    }

    private long createUniqueId() {
        long randomId = getRandomLong();
        while (true) {
            if (checkIfIdUnique(randomId)) {
                return randomId;
            } else {
                randomId = getRandomLong();
            }
        }
    }

    private long getRandomLong() {
        Random random = new Random();
        return random.nextInt(9999999);
    }

    private boolean checkIfIdUnique(long randomId) {
        List<OrderEntry> orderEntries = OrderMapper.getAllOrderEntries();

        if (orderEntries != null) {
            for (OrderEntry orderEntry : orderEntries) {
                long orderEntryId = orderEntry.getOrderEntryId();
                if (orderEntryId == randomId) {
                    return false;
                }
            }
        }
        return true;
    }
}
