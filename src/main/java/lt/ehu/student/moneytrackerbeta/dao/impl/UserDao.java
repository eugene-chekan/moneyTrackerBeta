package lt.ehu.student.moneytrackerbeta.dao.impl;

import lt.ehu.student.moneytrackerbeta.connection.ConnectionPool;
import lt.ehu.student.moneytrackerbeta.dao.BaseDao;
import lt.ehu.student.moneytrackerbeta.exception.DaoException;
import lt.ehu.student.moneytrackerbeta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BaseDao<User> {
    private static final String SELECT_ALL_USERS = "SELECT * FROM public.user";
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM public.user WHERE login = ?";
    private static final String INSERT_USER = "INSERT INTO public.user (login, password, email, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
    private static final Logger logger = LogManager.getLogger(UserDao.class);

    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                // Create User objects and add them to the list
                User user = new User(id, login, password, email, firstName, lastName);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("Error while retrieving users from the database", e);
            throw new DaoException("Error while retrieving users from the database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
        return users;
    }

    @Override
    public User findById(int id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Finding user by ID is not supported yet.");
    }

    public User findByLogin(String login) throws DaoException {
        Connection connection = null;
        PreparedStatement statement;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                // Create a User object
                return new User(id, login, password, email, firstName, lastName);
            }
        } catch (SQLException e) {
            logger.error("Error while retrieving a user by login from the database", e);
            throw new DaoException("Error while retrieving a user by login from the database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
        return null;
    }

    public boolean create(User user) throws DaoException {
        logger.info("Creating user: {}", user.getLogin());
        PreparedStatement statement;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_USER);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Error while adding a user to the database", e);
            throw new DaoException("Error while adding a user to the database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
    }

    @Override
    public boolean update(User user) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported yet.");
    }

    @Override
    public boolean delete(User user) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported for User");
    }
}
