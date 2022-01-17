package com.codegym;

public class Staff extends Cadre {
    private String work;

    public Staff() {
    }

    public Staff(String work) {
        this.work = work;
    }

    public Staff(String name, String birthDay, String sex, String address, String work) {
        super(name, birthDay, sex, address);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Nhân viên. " + super.toString() + ", công việc: " + this.work;
    }
}
