package lt.ehu.student.moneytrackerbeta.controller.command.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lt.ehu.student.moneytrackerbeta.controller.command.Command;
import lt.ehu.student.moneytrackerbeta.service.UserService;
import lt.ehu.student.moneytrackerbeta.service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException, SQLException {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        if (userService.isUsernameTaken(username)) {
            request.setAttribute("errorUserNameTaken", "Username is already taken. Try a different one.");
            return "pages/signup.jsp";
        }
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorPasswordMismatch", "Passwords do not match.");
            return "pages/signup.jsp";
        }
        userService.registerUser(username, password, firstName, lastName, email);
        request.setAttribute("successMessage", "Registration successful. You'll be redirected to login.");
        request.setAttribute("firstName", firstName);

        return "pages/signup_success.jsp";
    }
}
