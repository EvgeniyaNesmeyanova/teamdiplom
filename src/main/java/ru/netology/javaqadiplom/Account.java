package ru.netology.javaqadiplom;

public abstract class Account {
    protected static int balance;
    protected static int rate;

    public boolean pay(int amount) {
        return false;
    }

    public boolean add(int amount) {
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


}


