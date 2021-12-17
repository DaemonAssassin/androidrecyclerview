package com.gmail.mateendev3.androidrecyclerview;


//This is the Model/POJO/Data Holder class
public class Car {

    //declaring members
    private String carName;
    private int carImageResId;

    //public constructor
    public Car(String carName, int carImageResId) {
        this.carName = carName;
        this.carImageResId = carImageResId;
    }

    //getters and setters
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public int getCarImageResId() {
        return carImageResId;
    }
    public void setCarImageResId(int carImageResId) {
        this.carImageResId = carImageResId;
    }

    //toString() method override
    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carImageResId=" + carImageResId +
                '}';
    }
}
