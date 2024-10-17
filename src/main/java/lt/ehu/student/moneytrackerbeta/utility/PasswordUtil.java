package lt.ehu.student.moneytrackerbeta.utility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    // Hash a password for storing in the database
    public static String hashPassword(String plainPassword) {
        // Generate a salt and hash the password
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Check if the provided password matches the stored hashed password
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        // Check the password by comparing the hashed value
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}


