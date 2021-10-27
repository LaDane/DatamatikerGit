package com.example.shoppinglistwebsite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (pass1.equals(pass2)) {
//            out.println("<html><body>");
//            out.println("<h1>" + "Dit navn er " + navn + "</h1>");
//            out.println("</body></html>");

            HttpSession session = request.getSession();
            session.setAttribute("fname", fname);
            session.setAttribute("lname", lname);
            session.setAttribute("sessionId", session.getId());

            request.setAttribute("fname", fname);
            request.setAttribute("session", session);

            ServletContext servletContext = request.getServletContext();
            Users newUser = new Users(fname, lname);
            List<Users> usersList = (List<Users>) session.getAttribute("usersList");
            if (usersList == null) {
                usersList = new ArrayList<>();
            }
            usersList.add(newUser);
            servletContext.setAttribute("usersList", usersList);

            request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
        }
        else {
//            out.println("<html><body>");
//            out.println("<h1>" + "Dine passwords var ikke ens" + "</h1>");
//            out.println("</body></html>");

            String msg = "Dine passwords var ikke ens. Prøv igen!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}