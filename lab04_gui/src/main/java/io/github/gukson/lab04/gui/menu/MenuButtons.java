package io.github.gukson.lab04.gui.menu;

import io.github.gukson.lab04.client.dao.MeasurementDao;
import io.github.gukson.lab04.client.model.Measurement;
import io.github.gukson.lab04.gui.CoreUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MenuButtons {
    public void buttonsGenerator(List<Integer> data, JPanel rowHolderPanel, MenuGUI menuGUI, MeasurementDao measurementDao) throws SQLException {
        Integer buttonsInRow = 5;
        Integer licznik = 0;
        zewn: while(true){
            JPanel panel = new JPanel(new GridLayout(0,buttonsInRow));
            panel.setBackground(new Color(33, 59, 68));
            for(int x = 0; x<buttonsInRow;x++){
                JButton button = new JButton(measurementDao.getStationById(data.get(licznik)));
                button.setName(String.valueOf(data.get(licznik)));
                button.setContentAreaFilled(false);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(menuGUI.getContentPane());
                        coreui.toogleCharts(button.getName());
                    }
                });
                panel.add(button);

                licznik++;
                if(licznik == data.size()){
                    rowHolderPanel.add(panel);
                    break zewn;
                }
            }
            rowHolderPanel.add(panel);
        }

    }
}
