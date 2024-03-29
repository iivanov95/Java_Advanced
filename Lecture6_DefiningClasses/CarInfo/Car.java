package Lecture6_DefiningClasses.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    //Setters:
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public Car() {
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }
    public Car(String brand, String model) {
        this(brand, model, -1);
        setModel(model);
    }
    public Car(String brand, String model, int horsePower) {
        setBrand(brand);
        setModel(model);
        setHorsePower(horsePower);
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private String carInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}