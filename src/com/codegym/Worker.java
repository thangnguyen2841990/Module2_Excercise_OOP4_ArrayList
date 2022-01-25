package com.codegym;

public class Worker extends Cadre {
    private String level;
    public Worker(){
    }

    public Worker(String level) {
        this.level = level;
    }

    public Worker(String name, String birthDay, String sex, String address, String level) {
        super(name, birthDay, sex, address);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() + ", "+this.level;
    }
}
