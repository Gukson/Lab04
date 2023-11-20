package io.github.gukson.lab04.client.dao;

import io.github.gukson.lab04.client.model.Measurement;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MeasurementDao implements Dao<Measurement> {


    private Connection connection;

    public MeasurementDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Measurement> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Measurement> findAll() {
        List<Measurement> measurementList = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM data");
            stmt.setQueryTimeout(10);
            ResultSet measurementSet =  stmt.executeQuery();
            while (measurementSet.next()){
                measurementList.add(new Measurement(measurementSet.getInt("stationId"),measurementSet.getString("station"), LocalDate.parse(measurementSet.getString("dataPomiaru")), LocalTime.parse(measurementSet.getString("godzinaPomiaru")), measurementSet.getDouble("temperatura"),measurementSet.getInt("predkoscWiatru"), measurementSet.getInt("kierunekWiatru"), measurementSet.getDouble("wilgotnoscWzgledna"), measurementSet.getDouble("sumaOpadow"), measurementSet.getDouble("cisnienie")));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return measurementList;
    }

    @Override
    public Measurement save(Measurement measurement) {
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO data (stationId,station,dataPomiaru,godzinaPomiaru,temperatura,predkoscWiatru,kierunekWiatru,wilgotnoscWzgledna,sumaOpadow,cisnienie) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,measurement.getStationId());
            stmt.setString(2,measurement.getStation());
            stmt.setString(3,String.valueOf(measurement.getMeasurementData()));
            stmt.setString(4,String.valueOf(measurement.getMeasurementTime()));
            stmt.setDouble(5,measurement.getTemperature());
            stmt.setInt(6,measurement.getWindSpeed());
            stmt.setInt(7,measurement.getWindDirection());
            stmt.setDouble(8,measurement.getRelativeHumidity());
            stmt.setDouble(9,measurement.getTotalRainfall());
            stmt.setDouble(10,measurement.getPressure());

            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return measurement;
    }

    public boolean areDataFromThisDay(LocalDate date){
        try{

            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS liczba_wierszy FROM data WHERE dataPomiaru = (?)");
            stmt.setString(1,String.valueOf(date));
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.getInt(1) > 0){
                System.out.println("dane są aktualne");
                return true;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Measurement> getDataById(Integer stationId){
        List<Measurement> measurementList = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM data WHERE stationId = (?)");
            stmt.setInt(1,stationId);
            stmt.setQueryTimeout(10);
            ResultSet measurementSet =  stmt.executeQuery();
            while (measurementSet.next()){
                measurementList.add(new Measurement(measurementSet.getInt("stationId"),measurementSet.getString("station"), LocalDate.parse(measurementSet.getString("dataPomiaru")), LocalTime.parse(measurementSet.getString("godzinaPomiaru")), measurementSet.getDouble("temperatura"),measurementSet.getInt("predkoscWiatru"), measurementSet.getInt("kierunekWiatru"), measurementSet.getDouble("wilgotnoscWzgledna"), measurementSet.getDouble("sumaOpadow"), measurementSet.getDouble("cisnienie")));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return measurementList;
    }
}
