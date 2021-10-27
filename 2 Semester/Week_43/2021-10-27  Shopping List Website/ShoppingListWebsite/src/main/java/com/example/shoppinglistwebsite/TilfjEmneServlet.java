package com.example.shoppinglistwebsite;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TilføjEmneServlet", value = "/TilføjEmneServlet")
public class TilfjEmneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emne = request.getParameter("emne");
        log("emne: " + emne);

        HttpSession session = request.getSession();
        List<String> emneListe = (List<String>) session.getAttribute("emneListe");
        if (emneListe == null) {
            emneListe = new ArrayList<>();
        }
        emneListe.add(emne);
        session.setAttribute("emneListe", emneListe);

        ServletContext servletContext = request.getServletContext();
        List<String> alleBrugeresEmner = (List<String>) servletContext.getAttribute("alleBrugeresEmner");
        if (alleBrugeresEmner == null) {
            alleBrugeresEmner = new ArrayList<>();
        }
        alleBrugeresEmner.add(emne);
        servletContext.setAttribute("alleBrugeresEmner", alleBrugeresEmner);


        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
    }
}
