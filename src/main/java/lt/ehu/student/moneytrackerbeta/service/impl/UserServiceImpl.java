package lt.ehu.student.moneytrackerbeta.service.impl;

import lt.ehu.student.moneytrackerbeta.dao.UserDao;
import lt.ehu.student.moneytrackerbeta.model.User;
import lt.ehu.student.moneytrackerbeta.service.UserService;
import lt.ehu.student.moneytrackerbeta.utility.PasswordUtil;

import java.io.IOException;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public boolean verifyLogin(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    @Override
    public int registerUser(String username, String password, String firstName, String lastName, String email) throws SQLException, IOException {
        if (isUsernameTaken(username)) {
            return 1;
        }
        // Hash the password before storing it in the database
        String hashedPass = PasswordUtil.hashPassword(password);
        User user = new User(username, hashedPass, email, firstName, lastName);
        UserDao userDao = new UserDao();
        userDao.addUser(user);
        return 0;
    }

    @Override
    public boolean isUsernameTaken(String username) throws SQLException, IOException {
        UserDao user = new UserDao();
        User dbUser = user.getUserByLogin(username);
        if (dbUser == null) {
            return false;
        } else return dbUser.getLogin().equals(username);
    }
}
