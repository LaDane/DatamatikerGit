package business.persistence;

import business.entities.OrderEntry;
import business.entities.OrderEntryCombined;

import java.util.ArrayList;
import java.util.List;

public class OrderCombinedMapper {

    public static List<OrderEntryCombined> getOrderEntryCombined(List<OrderEntry> customerOrderEntries) {
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
        return customerOrderEntriesCombined;
    }
}
