package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
    double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));

    

        double bmi = calculateBMI(weight, height);



        String bodyType = determineBodyType(bmi);

    

        request.setAttribute("bmi", Math.round(bmi));
        request.setAttribute("bodyType", bodyType);


        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }

    // Calculate BMI
    private double calculateBMI(double weight, double height) {
        // BMI formula: BMI = weight(kg) / (height(m) * height(m))
        return weight / (height * height);
    }

    // Determine body type method 
    private String determineBodyType(double bmi) {
        if (bmi < 18.5) {
            return "underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "normal weight";
        } else if (bmi >= 24.9 && bmi < 29.9) {
            return "overweight";
        } else {
            return "obese";
        }
    }
}

