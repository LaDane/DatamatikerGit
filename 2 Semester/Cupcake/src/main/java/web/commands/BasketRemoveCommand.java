package web.commands;

import business.entities.BasketItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BasketRemoveCommand extends CommandUnprotectedPage{

    public BasketRemoveCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("removeBasketElement") != null) {
            int removeBasketElement = Integer.parseInt(request.getParameter("removeBasketElement"));

            HttpSession session = request.getSession();
            List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketItems");
            basketItems.remove(removeBasketElement);

            session.setAttribute("basketItems", basketItems);
        }

        return pageToShow;
    }
}
