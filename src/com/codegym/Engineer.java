package com.codegym;

public class Engineer extends Cadre {
    private String majors;

    public Engineer() {
    }

    public Engineer(String majors) {
        this.majors = majors;
    }

    public Engineer(String name, String birthDay, String sex, String address, String majors) {
        super(name, birthDay, sex, address);
        this.majors = majors;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    @Override
    public String toString() {
        return "Kỹ sư. "+ super.toString() + ", ngành đào tạo: "+this.majors;
    }
}
