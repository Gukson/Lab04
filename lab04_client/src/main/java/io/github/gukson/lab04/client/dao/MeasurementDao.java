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
    private String tableName;

    public MeasurementDao(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    @Override
    public Optional<Measurement> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Measurement> findAll() {
        List<Measurement> measurementList = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM (?)");
            stmt.setQueryTimeout(10);
            stmt.setString(1,this.tableName);
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
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO (?) (stationId,station,dataPomiaru,godzinaPomiaru,temperatura,predkoscWiatru,kierunekWiatru,wilgotnoscWzgledna,sumaOpadow,cisnienie) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,this.tableName);
            stmt.setInt(2,measurement.getStationId());
            stmt.setString(3,measurement.getStation());
            stmt.setString(4,String.valueOf(measurement.getMeasurementData()));
            stmt.setString(5,String.valueOf(measurement.getMeasurementTime()));
            stmt.setDouble(6,measurement.getTemperature());
            stmt.setInt(7,measurement.getWindSpeed());
            stmt.setInt(8,measurement.getWindDirection());
            stmt.setDouble(9,measurement.getRelativeHumidity());
            stmt.setDouble(10,measurement.getTotalRainfall());
            stmt.setDouble(11,measurement.getPressure());

            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return measurement;
    }

    public boolean areDataFromThisDay(LocalDate date){
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS liczba_wierszy FROM (?) WHERE dataPomiaru = '(?)'");
            stmt.setString(1,this.tableName);
            stmt.setString(2,String.valueOf(date));
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.getInt(1) > 0){
                return true;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
