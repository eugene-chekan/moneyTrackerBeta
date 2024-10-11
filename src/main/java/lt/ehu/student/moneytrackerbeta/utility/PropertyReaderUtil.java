package lt.ehu.student.moneytrackerbeta.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class PropertyReaderUtil {
    private static final Logger logger = LogManager.getLogger(PropertyReaderUtil.class);

    public static Properties readProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(fileName)) {
            properties.load(reader);
            logger.info("{} property file loaded.", fileName);
        } catch (FileNotFoundException ex) {
            logger.error("Property file {} not found.", fileName);
            throw new FileNotFoundException(ex.getMessage());
        }
        return properties;
    }
}

