package lt.ehu.student.moneytrackerbeta.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.ehu.student.moneytrackerbeta.controller.command.Command;
import lt.ehu.student.moneytrackerbeta.controller.command.CommandType;
import lt.ehu.student.moneytrackerbeta.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Controller.class);

    public void init() {
        logger.debug("Servlet initialized successfully.");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Received GET request. Will process.");
        try {
            processRequest(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
        logger.debug("Processed GET request.");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("Received POST request. Will process.");
        processRequest(request, response);
        logger.debug("Processed POST request.");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Processing request.");
        String commandStr = request.getParameter("command");
        if (commandStr == null || commandStr.isEmpty()) {
            commandStr = "DEFAULT";
        }
        Command command = CommandType.chooseCommand(commandStr);
        String page;
        String contextPath;
        try {
            page = command.execute(request);
            contextPath = request.getContextPath();
        } catch (CommandException e) {
            logger.error("Error while executing command", e);
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher(page).forward(request, response);
        logger.debug("Request processed. Forwarding to: {}", page);
    }

    public void destroy() {
        logger.info("Servlet destroyed.");
    }
}