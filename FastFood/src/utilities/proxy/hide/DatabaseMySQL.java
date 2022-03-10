package utilities.proxy.hide;

public class DatabaseMySQL implements Database{
    final private static Logger logger = Logger.getLogger(DatabaseMySQL.class.getName());
    public static Connection con = null;

    public static void connect(){
        try(InputStream input
                    = new FileInputStream("/Users/bernabe.cambarihan/Desktop/Bernabe/Java/JavaLab.03/FastFood/src/utility/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
            logger.info("Connected");
        }catch (IOException ex){
            logger.log(Level.SEVERE, "IOException : ", ex);
        }
    }

    public static void disconnect() {
        try{
            if(con != null){
                con.close();
                logger.info("Disconnected");
            }
        }catch (Exception e){
            logger.log(Level.SEVERE, "Not Connected", e);
        }
    }

    @Overide
    public void insertOrder(String order){
        connect();
        //insert query here
        disconnect();
    }
}