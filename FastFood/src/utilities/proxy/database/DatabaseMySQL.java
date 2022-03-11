package utilities.proxy.database;

import model.Transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMySQL implements Database{
    final private static Logger logger = Logger.getLogger(DatabaseMySQL.class.getName());

    private static Connection connection = null;

    private static String user = null;
    private static String password = null;
    private static String url = null;

    String sqlStatement = "";
    Statement statement = null;
    ResultSet resultSet = null;

    public static void getDatabaseProperties(){
        try(InputStream input = new FileInputStream("/Users/macrobert.cabote/IdeaProjects/GCash/JavaLabs/JavaLab.03/FastFood/src/utilities/proxy/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
            url = properties.getProperty("db.url");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connect(){
        getDatabaseProperties();
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                logger.info("Connected");
            } catch(SQLException sqle) {
                logger.info("Not Connected");
                sqle.printStackTrace();
            } catch (Exception e){
                logger.info("Not Connected");
                e.printStackTrace();
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


    @Override
    public void insertTransaction(Transaction transaction) {
        sqlStatement = "INSERT INTO "
                + "transactions(transactionID, customerName, totalAmount, timeStamp)"
                + "values (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);

            preparedStatement.setString(1, transaction.getTransactionID());
            preparedStatement.setString(2, transaction.getCustomerName());
            preparedStatement.setFloat(3, transaction.getTotalAmount());
            preparedStatement.setString(4, transaction.getTimeStamp());

            preparedStatement.executeUpdate();
            logger.log(Level.INFO, "Transaction [" + transaction.getTransactionID() + "] recorded.");

        } catch (SQLException sqle){
            logger.log(Level.SEVERE, "SQLException", sqle);
        } finally {
            try{
                if (statement != null){
                    statement.close();
                } if (resultSet != null){
                    resultSet.close();
                }
            } catch (Exception e){
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        disconnect();

    }

    @Override
    public int getTotalTransactions() {
        connect();
        ArrayList<Transaction> transactions = new ArrayList<>();
        sqlStatement = "SELECT * FROM transactions";

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                Transaction transaction = new Transaction(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getString(4));

                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions.size();
    }
}