package com.example.infosoft1.myapplication;

/**
 * Created by Infosoft1 on 9/23/2021.
 */

public class Flr {
    private String fcategory;
    private String flname;
    private String fldiscr;
    private String flprice;

    public Flr(){}

    public Flr(String fcategory,String flname,String fldiscr,String flprice){

        this.fcategory=fcategory;
        this.flname=flname;
        this.fldiscr=fldiscr;
        this.flprice=flprice;
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }

    public String getFldiscr() {
        return fldiscr;
    }

    public void setFldiscr(String fldiscr) {
        this.fldiscr = fldiscr;
    }

    public String getFlprice() {
        return flprice;
    }

    public void setFlprice(String flprice) {
        this.flprice = flprice;
    }
}
