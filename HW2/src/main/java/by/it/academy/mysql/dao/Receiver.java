package by.it.academy.mysql.dao;

import java.io.Serializable;

public class Receiver implements Serializable {

    private int numberReceiver;
    private String name;

    public Receiver() {

    }

    public int getNumberReceiver() {
        return numberReceiver;
    }

    public void setNumberReceiver(int numberReceiver) {
        this.numberReceiver = numberReceiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
