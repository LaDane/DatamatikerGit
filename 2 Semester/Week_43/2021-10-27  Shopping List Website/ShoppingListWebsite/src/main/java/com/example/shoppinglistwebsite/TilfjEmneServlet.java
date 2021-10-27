package com.example.shoppinglistwebsite;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@WebServlet(name = "TilføjEmneServlet", value = "/TilføjEmneServlet")
public class TilfjEmneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        String quantity = request.getParameter("quantity");
//        String fname = request.getParameter("fname");
        String fname = request.getSession().getAttribute("fname").toString();
        String lname = request.getSession().getAttribute("lname").toString();

        ItemObj itemObj = new ItemObj(item, quantity, fname, lname);

        log("item: " + item);
        log("quantity: "+ quantity);

        HttpSession session = request.getSession();
//        TreeSet<ItemObj> itemList = (TreeSet<ItemObj>) session.getAttribute("itemList");
        List<ItemObj> itemList = (List<ItemObj>) session.getAttribute("itemList");
        if (itemList == null) {
//            itemList = new TreeSet<>();
            itemList = new ArrayList<>();
        }
        itemList.add(itemObj);
        session.setAttribute("itemList", itemList);

//        ServletContext servletContext = request.getServletContext();
//        TreeSet<String> alleBrugeresEmner = (TreeSet<String>) servletContext.getAttribute("alleBrugeresEmner");
//        if (alleBrugeresEmner == null) {
//            alleBrugeresEmner = new TreeSet<>();
//        }
//        alleBrugeresEmner.add(item);
//        servletContext.setAttribute("alleBrugeresEmner", alleBrugeresEmner);


        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);


/*
        String Quantity = request.getParameter("Quantity");
        log("Quantity: " + Quantity);

        TreeSet<String> QuantityListe = (TreeSet<String>) session.getAttribute("QuantityListe");
        if (QuantityListe == null) {
                QuantityListe = new TreeSet<>();
        }
        QuantityListe.add(Quantity);
        session.setAttribute("QuantityListe", QuantityListe);
        TreeSet<String> alleBrugeresQuantity = (TreeSet<String>) servletContext.getAttribute("alleBrugeresQuantity");
        if (alleBrugeresQuantity == null) {
        alleBrugeresQuantity = new TreeSet<>();
        }
        alleBrugeresQuantity.add(Quantity);
        servletContext.setAttribute("alleBrugeresQuantity", alleBrugeresQuantity);


        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
 */
        }
}

