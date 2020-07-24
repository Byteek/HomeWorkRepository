package by.it.academy.mysql.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    Receiver getReceiver(int num) throws SQLException;

    List<Receiver> getAllReceivers() throws SQLException;

    Expense getExpense(int num) throws SQLException;

    List<Expense> getAllExpense() throws SQLException;

    int addReceiver(Receiver receiver) throws SQLException;

    int addExpense(Expense expense) throws SQLException;
}
