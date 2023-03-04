package com.example.weatherapp;

public class WeatherReportModel {
    private String main;
    private String description;
    private Double temp;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private int visibility;
    private double speed;

    public WeatherReportModel(String main, String description, double temp, double temp_min,
                              double temp_max, int pressure, int humidity, int visibility, double speed) {
        this.main = main;
        this.description = description;
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "WeatherReportModel{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", temp=" + temp +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", visibility=" + visibility +
                ", speed=" + speed +
                '}';
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
