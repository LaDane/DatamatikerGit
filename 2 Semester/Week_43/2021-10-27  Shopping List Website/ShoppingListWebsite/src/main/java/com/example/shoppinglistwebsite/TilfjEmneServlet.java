package com.example.shoppinglistwebsite;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

@WebServlet(name = "TilføjEmneServlet", value = "/TilføjEmneServlet")
public class TilfjEmneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from parameters and create ItemObj
        String item = request.getParameter("item");
        String quantity = request.getParameter("quantity");
        String fname = request.getSession().getAttribute("fname").toString();
        String lname = request.getSession().getAttribute("lname").toString();
        ItemObj itemObj = new ItemObj(item, quantity, fname, lname);

        // Quantity is not an int
        if (!Helpers.checkStringToInt(quantity)) {
            return;
        }

        // Get session and itemList
        HttpSession session = request.getSession();
        List<ItemObj> itemList = (List<ItemObj>) session.getAttribute("itemList");

        // If item is already added to the list, update the list
        Boolean itemAlreadyExists = false;
        if (itemList != null) {
            for (ItemObj io : itemList) {
                if (io.getItem().equalsIgnoreCase(item) && io.getFname().equalsIgnoreCase(fname) && io.getLname().equalsIgnoreCase(lname)) {
                    itemAlreadyExists = true;
                    updateItemObjQuantity(io, quantity);
                }
            }
        }

        // Create itemList if it does not exist
        if (itemList == null) {
            itemList = new ArrayList<>();
        }

        // Add item if it does not already exist in itemList
        if (!itemAlreadyExists) {
            itemList.add(itemObj);
        }
        session.setAttribute("itemList", itemList);

        // Get servletContext and allUserItems
        ServletContext servletContext = request.getServletContext();
        List<ItemObj> allUserItems = (List<ItemObj>) servletContext.getAttribute("allUserItems");

        // Update item quantity if item already exists in allUserItems list
//        if (allUserItems != null && itemAlreadyExists) {
//            for (ItemObj io : allUserItems) {
//                if (io.getItem().equalsIgnoreCase(item) && io.getFname().equalsIgnoreCase(fname) && io.getLname().equalsIgnoreCase(lname)) {
//                    updateItemObjQuantity(io, quantity);
//                }
//            }
//        }

        // Create allUserItems list if it does not exist
        if (allUserItems == null) {
            allUserItems = new ArrayList<>();
        }

        // Add item if it does not already exist
        if (!itemAlreadyExists) {
            allUserItems.add(itemObj);
        }
        servletContext.setAttribute("allUserItems", allUserItems);


        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
    }

    private void updateItemObjQuantity(ItemObj itemObj, String qToAdd) {
        int q1 = Helpers.convertIntToString(itemObj.getQuantity());
        int q2 = Helpers.convertIntToString(qToAdd);
        int total = q1 + q2;
        itemObj.quantity = Integer.toString(total);
    }
}

