package com.example.flowerparadise.model;

import android.widget.DatePicker;

import java.util.Date;

public class PaymentModel {
    private  String name;
    private int  cardno;
    private String expdate;
    private int pinno;


    public PaymentModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getCardno() {
        return cardno;
    }

    public void setCardno(int cardno) {
        this.cardno = cardno;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public int getPinno() {
        return pinno;
    }

    public void setPinno(int pinno) {
        this.pinno = pinno;
    }
}
