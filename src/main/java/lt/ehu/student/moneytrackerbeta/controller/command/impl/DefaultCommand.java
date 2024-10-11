package lt.ehu.student.moneytrackerbeta.controller.command.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lt.ehu.student.moneytrackerbeta.controller.command.Command;

import java.io.IOException;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return "index.jsp";
    }
}
