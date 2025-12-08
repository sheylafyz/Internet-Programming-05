package com.secj3303.model;

public class Person {

    private String name;
    private int yob;
    private double weight; // kg
    private double height; // m

    private String fullName;
    private String email;

    public Person() {
    }

    public Person(String name, int yob, double weight, double height) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getFullName() {
        return (fullName != null) ? fullName : name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBmi() {
        if (height <= 0) return 0;
        return weight / (height * height);
    }

    public String getCategory() {
        double bmi = getBmi();
        if (bmi == 0) return "Unknown";
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public double getBmiValue() {
        return getBmi();
    }

    public String getBmiCategory() {
        return getCategory();
    }
}
