package business.entities;

import business.persistence.UserMapper;

public class OrderEntry {
    private long orderEntryId;
    private int orderEntryUserId;
    private int orderEntryCupcakeBot;
    private int orderEntryCupcakeTop;
    private int orderEntryCupcakeAmount;

    public OrderEntry(long orderEntryId, int orderEntryUserId, int orderEntryCupcakeBot, int orderEntryCupcakeTop, int orderEntryCupcakeAmount) {
        this.orderEntryId = orderEntryId;
        this.orderEntryUserId = orderEntryUserId;
        this.orderEntryCupcakeBot = orderEntryCupcakeBot;
        this.orderEntryCupcakeTop = orderEntryCupcakeTop;
        this.orderEntryCupcakeAmount = orderEntryCupcakeAmount;
    }

    public long getOrderEntryId() {
        return orderEntryId;
    }

    public int getOrderEntryUserId() {
        return orderEntryUserId;
    }

    public String getOrderEntryUsername() {
        for (User user : UserMapper.getAllUsers()) {
            if (user.getId() == orderEntryUserId) {
                return user.getEmail();
            }
        }
        return null;
    }

    public int getOrderEntryCupcakeBot() {
        return orderEntryCupcakeBot;
    }

    public String getOrderEntryCupcakeBotName() {
        for (CupcakeBottom cb : CupcakeBottoms.getCupcakeBottoms()) {
            if (cb.getCupcakeBottomId() == orderEntryCupcakeBot) {
                return cb.getCupcakeBottomName();
            }
        }
        return null;
    }

    public int getOrderEntryCupcakeTop() {
        return orderEntryCupcakeTop;
    }

    public String getOrderEntryCupcakeTopName() {
        for (CupcakeTop ct : CupcakeTops.getCupcakeTops()) {
            if (ct.getCupcakeTopId() == orderEntryCupcakeTop) {
                return ct.getCupcakeTopName();
            }
        }
        return null;
    }

    public int getOrderEntryCupcakeAmount() {
        return orderEntryCupcakeAmount;
    }

    public double getOrderEntryTotal() {
        double total = 0;
        for (CupcakeBottom cb : CupcakeBottoms.getCupcakeBottoms()) {
            if (cb.getCupcakeBottomId() == orderEntryCupcakeBot) {
                total += cb.getCupcakeBottomPrice();
            }
        }
        for (CupcakeTop ct : CupcakeTops.getCupcakeTops()) {
            if (ct.getCupcakeTopId() == orderEntryCupcakeTop) {
                total += ct.getCupcakeTopPrice();
            }
        }
        total *= orderEntryCupcakeAmount;
        return total;
    }
}
