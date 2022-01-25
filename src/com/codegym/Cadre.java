package com.codegym;

public class Cadre {
    protected String name;
    protected String birthDay;
    protected String sex;
    protected String address;

    public Cadre() {
    }

    public Cadre(String name, String birthDay, String sex, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  this.name + ", " + this.birthDay + ", " + this.sex + ", " + this.address;
    }
}
