package io.github.gukson.lab04.client.service;

import io.github.gukson.lab04.client.dao.MeasurementDao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class View {
    private Connection connection;
    private MeasurementDao mDao;
    public void clientView() throws SQLException, IOException, ClassNotFoundException {
        String tableName = "data";
        URL url = new URL("https://danepubliczne.imgw.pl/api/data/synop/format/json");
        mDao = new MeasurementDao();
        MeasurementService service = new MeasurementService(url,mDao,tableName);
        service.checkDataStatus(LocalDate.now());
    }

    public Connection getConnection() {
        return connection;
    }

    public MeasurementDao getmDao() {
        return mDao;
    }
}
