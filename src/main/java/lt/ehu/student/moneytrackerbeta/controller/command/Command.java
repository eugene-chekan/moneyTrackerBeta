package lt.ehu.student.moneytrackerbeta.controller.command;

import jakarta.servlet.http.HttpServletRequest;
import lt.ehu.student.moneytrackerbeta.exception.CommandException;

@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
    default void refresh() {};
}
