package com.example.project;
public class User {

    private String name;
    private String surname;
    private int mountlyIncome;
    private String telephone;
    private String tcNo;
    private int creditScore;
    public User(){
        this.name="";
        this.surname="";
        this.mountlyIncome=0;
        this.telephone="";
        this.tcNo="";
        this.creditScore=0;
    }
    public String calculateCredit(){
        int creditLimitMultiplier=4;
        String creditResult="";
        if(this.creditScore<500){
            creditResult="Kredi başvurunuz reddedilmiştir";
        }else if(this.creditScore>500 && this.creditScore<1000 && this.mountlyIncome<5000){
            creditResult="10.000 TL ye kadar kredi kullanabilirsiniz.";
        }else{
            int credit=creditLimitMultiplier*this.mountlyIncome;
            creditResult=credit+"TL ye kadar kredi kullanabilirsiniz.";
        }
        return creditResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMountlyIncome() {
        return mountlyIncome;
    }

    public void setMountlyIncome(int mountlyIncome) {
        this.mountlyIncome = mountlyIncome;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
