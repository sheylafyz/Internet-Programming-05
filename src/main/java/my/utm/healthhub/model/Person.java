package my.utm.healthhub.model;

public class Person {

    private String name;
    private double height;
    private double weight;

    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public double getBmiValue() {
        return weight / (height * height);
    }

    public String getBmiCategory() {
        double bmi = getBmiValue();
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
}
