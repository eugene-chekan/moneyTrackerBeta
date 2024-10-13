package lt.ehu.student.moneytrackerbeta.connection;

import lt.ehu.student.moneytrackerbeta.utility.PropertyReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final int CONNECTION_POOL_CAPACITY = 2;
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> freeConnections = new LinkedBlockingQueue<>(CONNECTION_POOL_CAPACITY);
    private final BlockingQueue<Connection> usedConnections = new LinkedBlockingQueue<>(CONNECTION_POOL_CAPACITY);

    static {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            logger.error("Failed to register driver.", e);
        }
    }

    private ConnectionPool() {
        Path configPath = Path.of(System.getenv("CATALINA_HOME"), "webapps", "moneyTrackerBeta", "db.properties");
        Properties props = PropertyReaderUtil.readProperties(configPath.toString());
        final String URL = constructUrl(props);
        Connection connection = null;
        for (int i = 0; i < CONNECTION_POOL_CAPACITY; i++) {
            try {
                connection = DriverManager.getConnection(URL, props);
                logger.debug("Connection #{} created.", i);
            } catch (SQLException e) {
                logger.error("Failed to create connection.", e);
            }
            if (connection == null) {
                logger.error("Failed to add connection to the pool.");
            } else {
                freeConnections.add(connection);
                logger.debug("Connection #{} added to the pool.", i);
            }
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
            logger.debug("Connection pool created.");
        }
        logger.debug("Existing connection pool returned.");
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            logger.debug(
                    "Connection taken from the pool. Available connections: {}",
                    (CONNECTION_POOL_CAPACITY - freeConnections.remainingCapacity())
            );
            usedConnections.put(connection);
            logger.debug("Connection put to the used connections queue.");
        } catch (InterruptedException e) {
            logger.error("Failed to get connection from the pool.", e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        try {
            usedConnections.remove(connection);
            logger.debug("Connection removed from the used connections queue.");
            freeConnections.put(connection);
            logger.debug(
                    "Connection put back to the pool. Available connections: {}",
                    (CONNECTION_POOL_CAPACITY - freeConnections.remainingCapacity())
            );
        } catch (InterruptedException e) {
            logger.error("Failed to release connection to the pool.", e);
        }
    }

    private static String constructUrl(Properties props) {
        String driver = props.getProperty("driver");
        String type = props.getProperty("type");
        String host = props.getProperty("host");
        String port = props.getProperty("port");
        String database = props.getProperty("name");
        return driver + ":" + type + "://" + host + ":" + port + "/" + database;
    }
}
