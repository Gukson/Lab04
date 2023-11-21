package io.github.gukson.lab04.gui;
import io.github.gukson.lab04.client.Client;
import io.github.gukson.lab04.client.dao.MeasurementDao;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.defaultInitOverride","true");
        Client client = new Client();
        client.client();
        MeasurementDao measurementDao = client.getMeasurementDao();
        CoreUI coreUI = new CoreUI(measurementDao);
        coreUI.setVisible(true);
        coreUI.toogleMaenu();
    }
}