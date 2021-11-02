package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        switch (destination) {
            case "index": request.setAttribute("message", "Alt er godt!"); break;
            case "about": request.setAttribute("message", "Alt er super godt"); break;
            default: request.setAttribute("message", "Denne side findes ikke");
        }

        return destination;
    }
}
