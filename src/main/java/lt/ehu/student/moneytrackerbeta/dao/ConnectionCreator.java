package lt.ehu.student.moneytrackerbeta.dao;

import lt.ehu.student.moneytrackerbeta.utility.PropertyReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionCreator {
    private static final Logger logger = LogManager.getLogger(ConnectionCreator.class);

    public static Connection createConnection(String configPath) throws IOException {
        logger.debug("Current working directory: {}", System.getProperty("user.dir"));
        Properties props = PropertyReaderUtil.readProperties(configPath);
        final String URL = constructUrl(props);
        final String USERNAME = props.getProperty("db.username");
        final String PASSWORD = props.getProperty("db.password");
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            logger.error("Failed to create connection.", e);
        }
        return null;
    }

    private static String constructUrl(Properties props) {
        String driver = props.getProperty("db.driver");
        String type = props.getProperty("db.type");
        String host = props.getProperty("db.host");
        String port = props.getProperty("db.port");
        String database = props.getProperty("db.name");
        return driver + ":" + type + "://" + host + ":" + port + "/" + database;
    }
}
