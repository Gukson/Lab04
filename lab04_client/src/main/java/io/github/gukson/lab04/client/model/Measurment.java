package io.github.gukson.lab04.client.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public class Measurment {
    private Integer stationId;
    private String station;
    private LocalDate measurementData;
    private LocalTime measurementTime;
    private Double temperature;
    private Integer windSpeed;
    private Integer windDirection;
    private Double relativeHumidity;
    private Double totalRainfall;
    private Double pressure;

    public Measurment(Integer stationId, String station, LocalDate measurementData, LocalTime measurementTime, Double temperature, Integer windSpeed, Integer windDirection, Double relativeHumidity, Double totalRainfall, Double pressure) {
        this.stationId = stationId;
        this.station = station;
        this.measurementData = measurementData;
        this.measurementTime = measurementTime;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.relativeHumidity = relativeHumidity;
        this.totalRainfall = totalRainfall;
        this.pressure = pressure;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public LocalDate getMeasurementData() {
        return measurementData;
    }

    public void setMeasurementData(LocalDate measurementData) {
        this.measurementData = measurementData;
    }

    public LocalTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public Double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(Double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public Double getTotalRainfall() {
        return totalRainfall;
    }

    public void setTotalRainfall(Double totalRainfall) {
        this.totalRainfall = totalRainfall;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }
}
