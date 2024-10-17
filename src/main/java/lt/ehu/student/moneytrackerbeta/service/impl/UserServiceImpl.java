package lt.ehu.student.moneytrackerbeta.service.impl;

import lt.ehu.student.moneytrackerbeta.dao.impl.AssetDao;
import lt.ehu.student.moneytrackerbeta.dao.impl.UserDao;
import lt.ehu.student.moneytrackerbeta.exception.DaoException;
import lt.ehu.student.moneytrackerbeta.exception.ServiceException;
import lt.ehu.student.moneytrackerbeta.model.Asset;
import lt.ehu.student.moneytrackerbeta.model.User;
import lt.ehu.student.moneytrackerbeta.service.UserService;
import lt.ehu.student.moneytrackerbeta.utility.PasswordUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public boolean verifyLogin(String username, String password) throws ServiceException {
        UserDao userDao = new UserDao();
        User user;
        try {
            user = userDao.findByLogin(username);
        } catch (DaoException e) {
            throw new ServiceException("Error while verifying login", e);
        }
        if (user == null) {
            return false;
        }
        // Verify the password using the PasswordUtil class
        return PasswordUtil.checkPassword(password, user.getPassword());
    }

    @Override
    public boolean registerUser(String username, String password, String firstName, String lastName, String email) throws ServiceException {
        User user;
        Asset defaultAsset;
        if (isUsernameTaken(username)) {
            return false;
        }
        // Hash the password before storing it in the database
        String hashedPass = PasswordUtil.hashPassword(password);
        user = new User(username, hashedPass, email, firstName, lastName);
        UserDao userDao = new UserDao();
        AssetDao assetDao = new AssetDao();
        try {
            boolean userCreated = userDao.create(user);
            user = userDao.findByLogin(username);
            // Create a default asset for the user
            defaultAsset = new Asset(user.getId(), "Cash", "The default first asset", BigDecimal.valueOf(0.00), BigDecimal.valueOf(0.00), 1);
            assetDao.create(defaultAsset);
            return userCreated;
        } catch (DaoException | SQLException e) {
            throw new ServiceException("Error while registering user", e);
        }
    }

    @Override
    public boolean isUsernameTaken(String username) throws ServiceException {
        UserDao userDao = new UserDao();
        try {
            return userDao.findByLogin(username) != null;
        } catch (DaoException e) {
            throw new ServiceException("Error while checking if username is taken", e);
        }
    }

    @Override
    public String getFirstName(String username) throws ServiceException {
        UserDao userDao = new UserDao();
        try {
            return userDao.findByLogin(username).getFirstName();
        } catch (DaoException e) {
            throw new ServiceException("Error while getting first name", e);
        }
    }

    @Override
    public int getUserId(String username) throws ServiceException {
        UserDao userDao = new UserDao();
        try {
            return userDao.findByLogin(username).getId();
        } catch (DaoException e) {
            throw new ServiceException("Error while getting user ID", e);
        }
    }

    @Override
    public List<Asset> findAssets(int userId) throws ServiceException {
        AssetDao assetDao = new AssetDao();
        try {
            return assetDao.findAllByUserId(userId);
        } catch (DaoException | SQLException e) {
            throw new ServiceException("Error while getting assets", e);
        }
    }
}
