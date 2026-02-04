package my.utm.healthhub.model;

public class Person {

    private String name;
    private int yob;
    private double weight;
    private double height;
    private double bmi;
    private String category;

    // tambahan dari lab sebelumnya
    private String fullName;
    private String email;

    // ✅ WAJIB: no-arg constructor
    public Person() {
    }

    // constructor lama (biar lab 3 & 4 gak rusak)
    public Person(String name, int yob, double weight, double height) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.height = height;
    }

    // ===== getters =====
    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getBmi() {
        return bmi;
    }

    public String getCategory() {
        return category;
    }

    // alias getter (buat Thymeleaf / Hibernate nanti)
    public double getBmiValue() {
        return bmi;
    }

    public String getBmiCategory() {
        return category;
    }

    // ===== setters =====
    public void setName(String name) {
        this.name = name;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // ===== compatibility lab lama =====
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
}
