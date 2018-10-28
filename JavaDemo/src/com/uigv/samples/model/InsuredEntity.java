package com.uigv.samples.model;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class InsuredEntity {

    private String name;
    private String lastName;
    private String dni;
    private int age;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "InsuredEntity{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                '}';
    }
}
