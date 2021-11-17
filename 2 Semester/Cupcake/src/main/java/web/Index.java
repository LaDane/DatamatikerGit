package web;

import business.entities.BasketItem;
import business.entities.Cupcake;
import business.persistence.CupcakeCreation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Index", urlPatterns = {""})
public class Index extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("cupcakeBottom") != null) {
            int cupcakeBottomId = Integer.parseInt(request.getParameter("cupcakeBottom"));
            int cupcakeTopId = Integer.parseInt(request.getParameter("cupcakeTop"));
            int cupcakeAmount = Integer.parseInt(request.getParameter("cupcakeAmount"));
            Cupcake cupcake = CupcakeCreation.createCupcake(cupcakeBottomId, cupcakeTopId);

            if (cupcake != null) {
                double basketTotal = cupcake.getCupcakePrice() * cupcakeAmount;
                BasketItem basketItem = new BasketItem(cupcake, cupcakeAmount, basketTotal);

                HttpSession session = request.getSession();
                List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketItems");
                if (basketItems == null) {
                    basketItems = new ArrayList<>();
                }
                basketItems.add(basketItem);

                session.setAttribute("basketItems", basketItems);
//                ServletContext servletContext =request.getServletContext();
//                servletContext.setAttribute("basketItems", basketItems);
            }
        }

        request.getRequestDispatcher("/fc/index").forward(request, response);
    }
}
