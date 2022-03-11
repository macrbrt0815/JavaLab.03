package utilities.proxy.database;

import model.Transaction;

public interface Database {
    void insertTransaction(Transaction transaction);
    int getTotalTransactions();
}
