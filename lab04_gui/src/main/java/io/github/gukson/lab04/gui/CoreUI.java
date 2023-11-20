package io.github.gukson.lab04.gui;

import io.github.gukson.lab04.client.dao.*;

import javax.swing.*;
import java.lang.module.Configuration;
import java.sql.Connection;

public class CoreUI extends JFrame {
    private JPanel jpanel;

    public CoreUI (MeasurementDao measurementDao){

    }

    public void replaceView(JPanel jpanel){
        this.jpanel = jpanel;
        setContentPane(this.jpanel);
        this.revalidate();
    }
    public void tooglecCharts(Integer stationId){

    }
}
