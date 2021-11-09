package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import Util.BmiHelperFunctions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class Result extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        Double height = 0.0;
        Double weight = 0.0;

        try {
            height = Double.parseDouble(request.getParameter("height"));
            weight = Double.parseDouble(request.getParameter("weight"));
        } catch (Exception e) {
            throw new LoginSampleException("Du skal indtaste et tal som højde og vægt");
        }

        Double bmi = BmiHelperFunctions.calcBmi(height, weight);
        String bmiShort = String.format("%.2f", bmi);
        String category = BmiHelperFunctions.findCategory(bmi);

        String gender = request.getParameter("gender");

        int sport = 0;
        try {
            sport = Integer.parseInt(request.getParameter("sport"));
        } catch (Exception e) {
            throw new LoginSampleException("Fejl i sport parameter");
        }

        String[] infos = request.getParameterValues("info");
        List<String> infoList = null;
        if (infos != null) {
            infoList = Arrays.asList(infos);
        }

        request.setAttribute("height", height);
        request.setAttribute("weight", weight);
        request.setAttribute("bmi", bmiShort);
        request.setAttribute("category", category);
        request.setAttribute("gender", gender);
        request.setAttribute("sport", sport);
        request.setAttribute("infos", infoList);

        LogicFacade.insertBmiItem(height, weight, category, bmi, gender, sport, infoList);

        return "result";
    }
}
