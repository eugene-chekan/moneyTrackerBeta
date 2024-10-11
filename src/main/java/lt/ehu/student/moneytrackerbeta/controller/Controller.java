package lt.ehu.student.moneytrackerbeta.controller;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lt.ehu.student.moneytrackerbeta.controller.command.Command;
import lt.ehu.student.moneytrackerbeta.controller.command.CommandType;
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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.debug("Processed GET request.");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("Received POST request. Will process.");
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.debug("Processed POST request.");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        logger.debug("Processing request.");
        logger.debug("Request context path: {}", request.getContextPath());
        logger.debug("Request URI: {}", request.getRequestURI());
        logger.debug("Request params: {}", request.getParameterMap());
        String commandStr = request.getParameter("command");
        if (commandStr == null || commandStr.isEmpty()) {
            commandStr = "SHOW_MAIN_PAGE";
        }
        Command command = CommandType.chooseCommand(commandStr);
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);
        logger.debug("Request processed.");
        logger.debug("Request context path: {}", request.getContextPath());
        logger.debug("Request URI: {}", request.getRequestURI());
        logger.debug("Request params: {}", request.getParameterMap());
    }

    public void destroy() {
        logger.info("Servlet destroyed.");
    }
}