package io.github.gukson.lab04.gui;

import io.github.gukson.lab04.client.dao.*;
import io.github.gukson.lab04.gui.menu.MenuGUI;

import javax.swing.*;
import java.awt.*;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.SQLException;

public class CoreUI extends JFrame {
    private JPanel jpanel;
    private MeasurementDao measurementDao;

    public CoreUI (MeasurementDao measurementDao){
        this.measurementDao = measurementDao;
        setResizable(false);
        setAutoRequestFocus(false);
        setBounds(100, 100, 734, 409);
        setBackground(new Color(33, 59, 68));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void replaceView(JPanel jpanel){
        this.jpanel = jpanel;
        setContentPane(this.jpanel);
        this.revalidate();
    }
    public void toogleCharts(Integer stationId){

    }
    public void toogleMaenu(){
        MenuGUI gui = new MenuGUI(measurementDao);
        this.jpanel = gui.getContentPane();
        this.replaceView(this.jpanel);
    }
}
