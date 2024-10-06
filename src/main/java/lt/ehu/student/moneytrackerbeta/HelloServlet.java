package lt.ehu.student.moneytrackerbeta;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(HelloServlet.class);
    private String message;

    public void init() {
        message = "Hello World!";
        logger.info("Servlet initialized with message: {}", message);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("Received GET request. Will process.");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        logger.debug("Processed GET request.");
    }

    public void destroy() {
        logger.info("Servlet destroyed.");
    }
}