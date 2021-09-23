package com.example.flowerparadise.model;


public class Customer_details {

    private  String Sender_Name;
    private  String Sender_Address;
    private  String Sender_District;
    private Integer Sender_PrimaryConatct;
    private Integer Sender_SecondaryConatct;
    private  String Receiver_Name;
    private  String Receiver_Address;
    private  String Receiver_District;
    private  Integer Receiver_PrimaryConatct;
    private  String Receiver_Email;
    private String Receiver_DeliveryDate;

    public Customer_details() {
    }

    public String getSender_Name() {
        return Sender_Name;
    }

    public void setSender_Name(String sender_Name) {
        Sender_Name = sender_Name;
    }

    public String getSender_Address() {
        return Sender_Address;
    }

    public void setSender_Address(String sender_Address) {
        Sender_Address = sender_Address;
    }

    public String getSender_District() {
        return Sender_District;
    }

    public void setSender_District(String sender_District) {
        Sender_District = sender_District;
    }

    public Integer getSender_PrimaryConatct() {
        return Sender_PrimaryConatct;
    }

    public void setSender_PrimaryConatct(Integer sender_PrimaryConatct) {
        Sender_PrimaryConatct = sender_PrimaryConatct;
    }

    public Integer getSender_SecondaryConatct() {
        return Sender_SecondaryConatct;
    }

    public void setSender_SecondaryConatct(Integer sender_SecondaryConatct) {
        Sender_SecondaryConatct = sender_SecondaryConatct;
    }

    public String getReceiver_Name() {
        return Receiver_Name;
    }

    public void setReceiver_Name(String receiver_Name) {
        Receiver_Name = receiver_Name;
    }

    public String getReceiver_Address() {
        return Receiver_Address;
    }

    public void setReceiver_Address(String receiver_Address) {
        Receiver_Address = receiver_Address;
    }

    public String getReceiver_District() {
        return Receiver_District;
    }

    public void setReceiver_District(String receiver_District) {
        Receiver_District = receiver_District;
    }

    public Integer getReceiver_PrimaryConatct() {
        return Receiver_PrimaryConatct;
    }

    public void setReceiver_PrimaryConatct(Integer receiver_PrimaryConatct) {
        Receiver_PrimaryConatct = receiver_PrimaryConatct;
    }

    public String getReceiver_Email() {
        return Receiver_Email;
    }

    public void setReceiver_Email(String receiver_Email) {
        Receiver_Email = receiver_Email;
    }

    public String getReceiver_DeliveryDate() {
        return Receiver_DeliveryDate;
    }

    public void setReceiver_DeliveryDate(String receiver_DeliveryDate) {
        Receiver_DeliveryDate = receiver_DeliveryDate;
    }
}
