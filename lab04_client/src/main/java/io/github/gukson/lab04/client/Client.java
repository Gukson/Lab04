package io.github.gukson.lab04.client;

import io.github.gukson.lab04.client.dao.MeasurementDao;
import io.github.gukson.lab04.client.service.View;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;


public class Client {
    private Connection connection;
    private MeasurementDao measurementDao;
    public void client() {
        View view = new View();
        this.connection = view.getConnection();
        this.measurementDao = new MeasurementDao(connection);
        try {
            view.clientView();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public MeasurementDao getMeasurementDao() {
        return measurementDao;
    }
}
