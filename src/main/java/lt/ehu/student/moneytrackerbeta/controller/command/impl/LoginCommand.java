package lt.ehu.student.moneytrackerbeta.controller.command.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lt.ehu.student.moneytrackerbeta.controller.command.Command;
import lt.ehu.student.moneytrackerbeta.service.UserService;
import lt.ehu.student.moneytrackerbeta.service.impl.UserServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        UserService userService  = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page;
        if (userService.verifyLogin(username, password)) {
            BigDecimal income = new BigDecimal("100.99");
            BigDecimal expense = new BigDecimal("51.23");
            request.setAttribute("userName", username);
            request.setAttribute("currentDate", new java.util.Date());
            request.setAttribute("income", income);
            request.setAttribute("expense", expense);
            request.setAttribute("balance", income.subtract(expense));
            page = "pages/dashboard.jsp";
        } else {
            request.setAttribute("errorUserPassMessage", "Invalid username or password");
            page = "pages/login.jsp";
        }
        return page;
    }
}
