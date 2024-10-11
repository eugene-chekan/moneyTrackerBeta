package lt.ehu.student.moneytrackerbeta.controller.command;

import lt.ehu.student.moneytrackerbeta.controller.command.impl.DefaultCommand;
import lt.ehu.student.moneytrackerbeta.controller.command.impl.LoginCommand;
import lt.ehu.student.moneytrackerbeta.controller.command.impl.LogoutCommand;
import lt.ehu.student.moneytrackerbeta.controller.command.impl.SignUpCommand;

public enum CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    SIGNUP(new SignUpCommand()),
    DEFAULT(new DefaultCommand());
    final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command chooseCommand(String command) {
        return CommandType.valueOf(command.toUpperCase()).command;
    }
}
