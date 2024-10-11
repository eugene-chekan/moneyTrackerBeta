package lt.ehu.student.moneytrackerbeta.dao;

import lt.ehu.student.moneytrackerbeta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String DB_PROPERTIES_FILE = "C:\\Users\\eugen\\IdeaProjects\\apache-tomcat-10.1.30\\webapps\\moneyTrackerBeta\\db.properties";
    private static final Logger logger = LogManager.getLogger(UserDao.class);

    public List<User> getAllUsers() throws IOException, SQLException {
        List<User> users = new ArrayList<>();
        // Implement the logic to retrieve all users from the database
        // Return a list of User objects
        final String SELECT_ALL_USERS = "SELECT * FROM users";
        try (Connection connection = ConnectionCreator.createConnection(DB_PROPERTIES_FILE);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)) {
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
        }
        return users;
    }

    public User getUserByLogin(String login) throws IOException, SQLException {
        logger.debug("Current working directory: {}", System.getProperty("user.dir"));
        // Implement the logic to retrieve a user by login from the database
        // Return a User object
        final String SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
        try (Connection connection = ConnectionCreator.createConnection(DB_PROPERTIES_FILE);
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    // Create a User object
                    return new User(id, login, password, email, firstName, lastName);
                }
            }
        } catch (SQLException e) {
            logger.error("Error while retrieving a user by login from the database", e);
        }
        return null;
    }

    public void addUser(User user) throws IOException, SQLException {
        logger.debug("Current working directory: {}", System.getProperty("user.dir"));
        // Implement the logic to add a user to the database
        final String INSERT_USER = "INSERT INTO users (login, password, email, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionCreator.createConnection(DB_PROPERTIES_FILE);
             PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error while adding a user to the database", e);
        }
    }
}
