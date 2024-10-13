package lt.ehu.student.moneytrackerbeta.service;

import java.io.IOException;
import java.sql.SQLException;

public interface UserService {
    boolean verifyLogin(String username, String password) throws SQLException, IOException;
    boolean registerUser(String username, String password, String firstName, String lastName, String email) throws SQLException, IOException;
    boolean isUsernameTaken(String username) throws SQLException, IOException;
}
