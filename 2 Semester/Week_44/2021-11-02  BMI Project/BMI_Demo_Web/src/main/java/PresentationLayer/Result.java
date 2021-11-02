package PresentationLayer;

import FunctionLayer.LoginSampleException;
import Util.BmiHelperFunctions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        request.setAttribute("height", height);
        request.setAttribute("weight", weight);
        request.setAttribute("bmi", bmiShort);
        request.setAttribute("category", category);

        return "result";
    }
}
