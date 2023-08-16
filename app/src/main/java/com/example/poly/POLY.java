package com.example.poly;

public class POLY {
    private int Year;
    private String type;
    private int enrolment;

    public POLY(int Year,String type,int enrolment){
        this.Year=Year;
        this.type=type;
        this.enrolment=enrolment;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    @Override
    public String toString() {
        return "POLY{" +
                "Year=" + Year +
                ", type='" + type + '\'' +
                ", enrolment=" + enrolment +
                '}';
    }
}
