package io.github.gukson.lab04.gui.charts;

import io.github.gukson.lab04.client.dao.MeasurementDao;
import io.github.gukson.lab04.client.model.Measurement;
import io.github.gukson.lab04.gui.panel.PanelShadow;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RunCharts extends JFrame {

    private io.github.gukson.lab04.gui.charts.CurveLineChart chart;
    private io.github.gukson.lab04.gui.panel.PanelShadow panelShadow1;

    private String name;
    private MeasurementDao measurementDao;

    public RunCharts(String name, MeasurementDao measurementDao)  {
        this.name = name;
        this.measurementDao = measurementDao;
    }

    public JPanel initComponents() {

        panelShadow1 = new io.github.gukson.lab04.gui.panel.PanelShadow();
        chart = new io.github.gukson.lab04.gui.charts.CurveLineChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
                panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
                panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);

        return panelShadow1;
    }

    //Kolejność danych: temperatura, predkosc wiatru, kierunek wiatru, wilgotność względna, suma opadów, cisnienie
    public void AddData() {
        chart.clear();
        List<Measurement> list = measurementDao.getDataById(Integer.parseInt(this.name));
        for(Measurement m: list){
            chart.addData(new ModelChart(String.valueOf(m.getMeasurementData()), new double[]{m.getTemperature(),m.getWindSpeed(),m.getWindDirection(),m.getRelativeHumidity(),m.getTotalRainfall(),m.getPressure()}));
            //TODO problem with Total Rainfall amount - maybe do it x100?
            //TODO make data more vertical to save space when lot of data
        }

        //metoda addData dodaje labele do listy punktów w poziomej skali oraz wylicza na bierzącą maksymalną skalę poziomą
        //tu są narzucone wartości
        chart.start();
    }

    public void AddLegends(){
        chart.setTitle("Chart Data");
        chart.addLegend("Temperature", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Wind speed", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Wind direction", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart.addLegend("Relative Humanity", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart.addLegend("Total Rainfall", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart.addLegend("Pressure", Color.decode("#0099F7"), Color.decode("#F11712"));
        //TODO get more colors combination
    }


}
