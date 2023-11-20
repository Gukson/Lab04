package io.github.gukson.lab04.client.service;

import io.github.gukson.lab04.client.dao.MeasurementDao;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class View {
    private Connection connection;
    public void clientView() throws SQLException, MalformedURLException, ClassNotFoundException {
        String tableName = "data";
        URL url = new URL("https://danepubliczne.imgw.pl/api/data/synop/format/json");
        this.connection = DriverManager.getConnection("jdbc:sqlite:/Users/kuba/Documents/MojeDokumenty/studia/III semestr/Kubik/Lab04/lab04_client/src/main/java/io/github/gukson/lab04/client/database/dataBase.db");
        MeasurementDao mDao = new MeasurementDao(this.connection);
        MeasurementService service = new MeasurementService(url,mDao,tableName);
        service.checkDataStatus(LocalDate.now());
    }

    public Connection getConnection() {
        return connection;
    }
}
