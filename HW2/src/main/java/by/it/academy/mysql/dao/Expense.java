package by.it.academy.mysql.dao;

import java.io.Serializable;
import java.sql.Date;

public class Expense implements Serializable {
    private int numberExpense;
    private Date payDate;
    private int numberReceiver;
    private double value;

    public Expense() {
    }

    public int getNumberExpense() {
        return numberExpense;
    }

    public void setNumberExpense(int numberExpense) {
        this.numberExpense = numberExpense;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getNumberReceiver() {
        return numberReceiver;
    }

    public void setReceiver(int numberReceiver) { this.numberReceiver = numberReceiver;  }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
