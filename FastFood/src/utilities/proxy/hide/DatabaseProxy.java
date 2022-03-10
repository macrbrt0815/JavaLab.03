package utilities.proxy.hide;

public class DatabaseProxy implements Database{
    private Database db = new DatabaseMySQL();

    @Override
    public void insertSMS(String SMS) {
        db.insertOrder("some order");
    }
}
