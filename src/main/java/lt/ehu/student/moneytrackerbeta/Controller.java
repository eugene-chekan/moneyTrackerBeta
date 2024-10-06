package lt.ehu.student.moneytrackerbeta;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "helloServlet", value = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Controller.class);

    public void init() {
        logger.debug("Servlet initialized successfully.");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("Received GET request. Will process.");
        String inputNum = request.getParameter("num");
        int multiplier = 2;
        int resultNum = Integer.parseInt(inputNum) * multiplier;
        request.setAttribute("input", inputNum);
        request.setAttribute("result", resultNum);
        request.setAttribute("multiplier", multiplier);
        request.getRequestDispatcher("pages/main.jsp").forward(request, response);
        response.setContentType("text/html");
        logger.debug("Processed GET request.");
    }

    public void destroy() {
        logger.info("Servlet destroyed.");
    }
}