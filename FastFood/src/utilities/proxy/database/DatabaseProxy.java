package utilities.proxy.database;

import model.Transaction;

public class DatabaseProxy implements Database{
    private Database database = new DatabaseMySQL();

    @Override
    public void insertTransaction(Transaction transaction) {
        database.insertTransaction(transaction);
    }

    @Override
    public int getTotalTransactions() {
        return database.getTotalTransactions();
    }
}
