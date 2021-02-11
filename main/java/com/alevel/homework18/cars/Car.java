package com.alevel.homework18.cars;

import java.util.Arrays;

public class Car {
    private String brand;
    private String model;
    private String[] colors;
    private String maxSpeedUnit;
    private Integer maxSpeedValue;
    private Double volume;
    private Integer rpm;
    private String compressionRatio;
    private Integer seatingCapacity;

    public Car(String brand, String model, String[] colors, String maxSpeedUnit, Integer maxSpeedValue, Double volume, Integer rpm, String compressionRatio, Integer seatingCapacity) {
        this.brand = brand;
        this.model = model;
        this.colors = colors;
        this.maxSpeedUnit = maxSpeedUnit;
        this.maxSpeedValue = maxSpeedValue;
        this.volume = volume;
        this.rpm = rpm;
        this.compressionRatio = compressionRatio;
        this.seatingCapacity = seatingCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String getMaxSpeedUnit() {
        return maxSpeedUnit;
    }

    public void setMaxSpeedUnit(String maxSpeedUnit) {
        this.maxSpeedUnit = maxSpeedUnit;
    }

    public Integer getMaxSpeedValue() {
        return maxSpeedValue;
    }

    public void setMaxSpeedValue(Integer maxSpeedValue) {
        this.maxSpeedValue = maxSpeedValue;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Integer getRpm() {
        return rpm;
    }

    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(String compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colors=" + Arrays.toString(colors) +
                ", maxSpeedUnit='" + maxSpeedUnit + '\'' +
                ", maxSpeedValue=" + maxSpeedValue +
                ", volume=" + volume +
                ", rpm=" + rpm +
                ", compressionRatio='" + compressionRatio + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }
}
