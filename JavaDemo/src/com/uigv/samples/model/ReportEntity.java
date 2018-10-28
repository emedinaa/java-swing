package com.uigv.samples.model;

public class ReportEntity {

    private String fullName;
    private int age;
    private int consultation;
    private Double totalAmount;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getConsultation() {
        return consultation;
    }

    public void setConsultation(int consultation) {
        this.consultation = consultation;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
