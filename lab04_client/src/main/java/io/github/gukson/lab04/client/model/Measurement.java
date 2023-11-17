package io.github.gukson.lab04.client.model;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.apache.commons.lang3.math.NumberUtils.toDouble;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class Measurement {
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

    public Measurement(Integer stationId, String station, LocalDate measurementData, LocalTime measurementTime, Double temperature, Integer windSpeed, Integer windDirection, Double relativeHumidity, Double totalRainfall, Double pressure) {
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

    public Measurement(MeasurmentExternal m) {
        this.stationId = toInt(m.getIdStacji());
        this.station = m.getStacja();
        this.measurementData =  LocalDate.parse(m.getDataPomiaru());
        if(m.getGodzinaPomiaru().length() == 1){
            this.measurementTime = LocalTime.parse("0" + m.getGodzinaPomiaru()+ ":00" );
        }else{
            this.measurementTime = LocalTime.parse(m.getGodzinaPomiaru()+ ":00" );
        }

        this.temperature = toDouble(m.getTemperatura());
        this.windSpeed = toInt(m.getPredkoscWiatru());
        this.windDirection =  toInt(m.getKierunekWiatru());
        this.relativeHumidity = toDouble(m.getWilgotnoscWzgledna());
        this.totalRainfall = toDouble(m.getSumaOpadu());
        this.pressure = toDouble(m.getCisnienie());
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
