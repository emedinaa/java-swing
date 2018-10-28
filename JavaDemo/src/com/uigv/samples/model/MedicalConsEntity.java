package com.uigv.samples.model;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class MedicalConsEntity {

    private int id;
    private String insuredDNI;
    private int count;
    private Double payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsuredDNI() {
        return insuredDNI;
    }

    public void setInsuredDNI(String insuredDNI) {
        this.insuredDNI = insuredDNI;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "MedicalConsEntity{" +
                "id=" + id +
                ", insuredDNI='" + insuredDNI + '\'' +
                ", count=" + count +
                ", payment=" + payment +
                '}';
    }
}
