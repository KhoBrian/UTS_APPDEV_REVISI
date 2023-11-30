package com.example.utsappdev;

public class Transaksi {
    int id;
    String username;
    String password;
    String date;
    String amount;
    String debitCredit;

    public Transaksi(String username, String password,String date, String amount, String debitCredit) {
        this.username = username;
        this.password = password;

        this.date = date;
        this.amount = amount;
        this.debitCredit = debitCredit;
    }

    public Transaksi(int id, String date, String amount, String debitCredit) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.debitCredit = debitCredit;
    }

    public int getId() {

        return id;
    }

    public String getUsername() {

        return username;
    }
    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getAmount() {

        return amount;
    }

    public void setAmount(String amount) {

        this.amount = amount;
    }

    public String getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(String debitCredit) {

        this.debitCredit = debitCredit;
    }

}
