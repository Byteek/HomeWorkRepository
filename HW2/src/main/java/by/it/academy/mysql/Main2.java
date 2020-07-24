package by.it.academy.mysql;


import by.it.academy.mysql.dao.Dao;
import by.it.academy.mysql.dao.DaoDtoFactory;
import by.it.academy.mysql.dao.Expense;
import by.it.academy.mysql.dao.Receiver;

import java.sql.Date;
import java.sql.SQLException;

public class Main2 {

    public static void main(String[] args) throws SQLException {


        Receiver receiver1 = new Receiver();
        Receiver receiver2 = new Receiver();
        Receiver receiver3 = new Receiver();

        receiver1.setNumberReceiver(1);
        receiver1.setName("Euroopt");

        receiver2.setNumberReceiver(2);
        receiver2.setName("Korona");

        receiver3.setNumberReceiver(3);
        receiver3.setName("Gippo");

        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        Expense expense3 = new Expense();

        expense1.setNumberExpense(1);
        expense1.setPayDate(Date.valueOf("2020-07-12"));
        expense1.setReceiver(1);
        expense1.setValue(9_000);

        expense2.setNumberExpense(2);
        expense2.setPayDate(Date.valueOf("2020-07-13"));
        expense2.setReceiver(2);
        expense2.setValue(5_000);

        expense3.setNumberExpense(3);
        expense3.setPayDate(Date.valueOf("2020-07-14"));
        expense3.setReceiver(3);
        expense3.setValue(100_000);

        Dao myDao = DaoDtoFactory.getDaoDto("mydb");
        //add receivers
        myDao.addReceiver(receiver1);
        myDao.addReceiver(receiver2);
        myDao.addReceiver(receiver3);
        //add expense
        myDao.addExpense(expense1);
        myDao.addExpense(expense2);
        myDao.addExpense(expense3);
        //read receiver 2
        myDao.getReceiver(2);

        //read all receiver
        myDao.getAllReceivers();

        //read expense 3
        myDao.getExpense(3);

        //read all expense
        myDao.getAllExpense();

    }


}
