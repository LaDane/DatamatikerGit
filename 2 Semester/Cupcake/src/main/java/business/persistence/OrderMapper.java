package business.persistence;

import business.entities.OrderEntry;
import web.FrontController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<OrderEntry> getAllOrderEntries() {
        List<OrderEntry> orderEntriesList = null;

        try {
            String sql = "SELECT * FROM orders";
            Connection connection = FrontController.database.connect();
            PreparedStatement ps = connection.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (orderEntriesList == null) {
                    orderEntriesList = new ArrayList<>();
                }
                int orderEntryId = rs.getInt("order_id");
                int orderEntryUserId = rs.getInt("users_user_id");
                int orderEntryCupcakeBot = rs.getInt("cupcake_bot");
                int orderEntryCupcakeTop = rs.getInt("cupcake_top");
                int orderEntryCupcakeAmount = rs.getInt("amount");

                OrderEntry orderEntry = new OrderEntry(orderEntryId, orderEntryUserId, orderEntryCupcakeBot, orderEntryCupcakeTop, orderEntryCupcakeAmount);
                orderEntriesList.add(orderEntry);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderEntriesList;
    }

    public static List<OrderEntry> getOrderEntriesByOrderId(long order_id) {
        List<OrderEntry> orderEntries = getAllOrderEntries();
        List<OrderEntry> orderEntriesById = null;

        for (OrderEntry orderEntry : orderEntries) {
            if (orderEntry.getOrderEntryId() == order_id) {
                if (orderEntriesById == null) {
                    orderEntriesById = new ArrayList<>();
                }
                orderEntriesById.add(orderEntry);
            }
        }
        return orderEntriesById;
    }

    public static List<OrderEntry> getOrderEntriesByUserId(int user_id) {
        List<OrderEntry> orderEntries = getAllOrderEntries();
        List<OrderEntry> orderEntriesByUserId = null;

        for (OrderEntry orderEntry : orderEntries) {
            if (orderEntry.getOrderEntryUserId() == user_id) {
                if (orderEntriesByUserId == null) {
                    orderEntriesByUserId = new ArrayList<>();
                }
                orderEntriesByUserId.add(orderEntry);
            }
        }
        return orderEntriesByUserId;
    }
}
