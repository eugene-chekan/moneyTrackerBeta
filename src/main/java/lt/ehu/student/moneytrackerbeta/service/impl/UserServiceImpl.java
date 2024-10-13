package lt.ehu.student.moneytrackerbeta.service.impl;

import lt.ehu.student.moneytrackerbeta.dao.impl.UserDao;
import lt.ehu.student.moneytrackerbeta.model.User;
import lt.ehu.student.moneytrackerbeta.service.UserService;
import lt.ehu.student.moneytrackerbeta.utility.PasswordUtil;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public boolean verifyLogin(String username, String password) throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.findByLogin(username);
        if (user == null) {
            return false;
        }
        // Verify the password using the PasswordUtil class
        return PasswordUtil.checkPassword(password, user.getPassword());
    }

    @Override
    public boolean registerUser(String username, String password, String firstName, String lastName, String email) throws SQLException {
        if (isUsernameTaken(username)) {
            return false;
        }
        // Hash the password before storing it in the database
        String hashedPass = PasswordUtil.hashPassword(password);
        User user = new User(username, hashedPass, email, firstName, lastName);
        UserDao userDao = new UserDao();
        try {
            return userDao.create(user);
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean isUsernameTaken(String username) throws SQLException {
        UserDao user = new UserDao();
        User dbUser = user.findByLogin(username);
        if (dbUser == null) {
            return false;
        } else return dbUser.getLogin().equals(username);
    }
}
