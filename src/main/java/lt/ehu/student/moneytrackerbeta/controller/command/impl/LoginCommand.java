package lt.ehu.student.moneytrackerbeta.controller.command.impl;

import jakarta.servlet.http.HttpServletRequest;
import lt.ehu.student.moneytrackerbeta.controller.command.Command;
import lt.ehu.student.moneytrackerbeta.exception.ServiceException;
import lt.ehu.student.moneytrackerbeta.model.Asset;
import lt.ehu.student.moneytrackerbeta.service.UserService;
import lt.ehu.student.moneytrackerbeta.service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd yyyy");
        String date = dateFormat.format(new java.util.Date());
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page;
        try {
            if (userService.verifyLogin(username, password)) {
                String firstName = userService.getFirstName(username);
                int userId = userService.getUserId(username);
                List<Asset> assets = userService.findAssets(userId);
                request.setAttribute("assets", assets);
                BigDecimal income = new BigDecimal("100.99");
                BigDecimal expense = new BigDecimal("51.23");
                request.setAttribute("userName", firstName);
                request.setAttribute("currentDate", date);
                request.setAttribute("income", income);
                request.setAttribute("expense", expense);
                request.setAttribute("balance", income.subtract(expense));
                page = "pages/dashboard.jsp";
            } else {
                request.setAttribute("errorUserPassMessage", "Invalid username or password");
                page = "pages/login.jsp";
            }
        } catch (ServiceException e) {
            request.setAttribute("errorMessage", "An error occurred while logging in. Try again later.");
            page = "pages/login.jsp";
        }
        return page;
    }
}
