package utilities.proxy.hide;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMySQL implements Database{
    final private static Logger logger = Logger.getLogger(DatabaseMySQL.class.getName());
    private static Connection connection = null;

    public static void connect(){
        /*
        try(

                //InputStream input = new FileInputStream("/Users/bernabe.cambarihan/Desktop/Bernabe/Java/JavaLab.03/FastFood/src/utility/config.properties")) {
                //Properties prop = new Properties();
                //prop.load(input);

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
            logger.info("Connected");
        }catch (IOException ex){
            logger.log(Level.SEVERE, "IOException : ", ex);
        }
        */
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_database?useTimezone=true&serverTimezone=UTC", "root", "951236541");
                logger.info("Connected");
            } catch(SQLException sqle) {
                sqle.printStackTrace();
                logger.info("Not Connected");
            } catch (Exception e){
                e.printStackTrace();
                logger.info("Not Connected");
            }
        }
    }

    public static void disconnect() {
        try {
            if (connection != null){
                connection.close();
                logger.info("Disconnected");
            }
        } catch (Exception e){
            logger.log(Level.SEVERE, "Not Connected", e);
        }
    }
}