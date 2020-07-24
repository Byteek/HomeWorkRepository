package by.it.academy.mysql.dao.mysql;

import by.it.academy.mysql.dao.Dao;
import by.it.academy.mysql.dao.Expense;
import by.it.academy.mysql.dao.Receiver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DaoDto implements Dao {

    private static Logger logger = Logger.getLogger(DaoDto.class.getName());

    private Connection connection;
    private boolean isTestInstanse;
    private Receiver receiver;
    private Expense expense;

    public DaoDto() throws SQLException {
        connection = MySqlClassConnection.getConnection();
    }

    @Override
    public Receiver getReceiver(int num) throws SQLException {
        logger.info("Read receiver:" + num + " of database ");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from receivers where num=?;"
        );
        preparedStatement.setInt(1, num);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Receiver> receivers = parseResultSetReceivers(resultSet);
        preparedStatement.close();
        return receivers.size() > 0 ? receivers.get(0) : null;
    }

    @Override
    public List<Receiver> getAllReceivers() throws SQLException {
        logger.info("Read all receivers");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from receivers;"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Receiver> receivers = parseResultSetReceivers(resultSet);
        preparedStatement.close();
        return receivers;
    }

    private List<Receiver> parseResultSetReceivers(ResultSet resultSet) throws SQLException {
        List<Receiver> receivers = new ArrayList<>();
        while (resultSet.next()) {
            Receiver receiver = new Receiver();
            receiver.setNumberReceiver(resultSet.getInt("num"));
            receiver.setName(resultSet.getString("name"));
            receivers.add(receiver);
        }
        return receivers;
    }


    @Override
    public Expense getExpense(int num) throws SQLException {
        logger.info("Read expense:" + num + " of database ");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from expenses where num=?;"
        );
        preparedStatement.setInt(1, num);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Expense> expenses = parseResultSetExpense(resultSet);
        preparedStatement.close();
        return expenses.size() > 0 ? expenses.get(0) : null;
    }

    @Override
    public List<Expense> getAllExpense() throws SQLException {
        logger.info("Read all expenses");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from expenses;"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Expense> expenses = parseResultSetExpense(resultSet);
        preparedStatement.close();
        return expenses;
    }

    private List<Expense> parseResultSetExpense(ResultSet resultSet) throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        while (resultSet.next()) {
            Expense expense = new Expense();
            expense.setNumberExpense(resultSet.getInt("num"));
            expense.setPayDate(resultSet.getDate("paydate"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setValue(resultSet.getDouble("value"));
            expenses.add(expense);
        }
        return expenses;
    }

    @Override
    public int addReceiver(Receiver receiver) throws SQLException {
        logger.info("Add receiver to database:" + receiver.getName());

        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into receivers values(?,?)"
        );
        preparedStatement.setInt(1, receiver.getNumberReceiver());
        preparedStatement.setString(2, receiver.getName());
        boolean execute = preparedStatement.execute();

        if (execute) {
            return receiver.getNumberReceiver();
        }
        return -1;
    }

    @Override
    public int addExpense(Expense expense) throws SQLException {
        logger.info("Add expense to database:" + expense.getNumberExpense());

        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into expenses values(?,?,?,?)"
        );
        preparedStatement.setInt(1, expense.getNumberExpense());
        preparedStatement.setDate(2, expense.getPayDate());
        preparedStatement.setInt(3, expense.getNumberReceiver());
        preparedStatement.setDouble(4, expense.getValue());

        boolean execute = preparedStatement.execute();

        if (execute) {
            return receiver.getNumberReceiver();
        }

        return -1;
    }
}
