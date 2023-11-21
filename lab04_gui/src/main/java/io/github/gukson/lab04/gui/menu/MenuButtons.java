package io.github.gukson.lab04.gui.menu;

import io.github.gukson.lab04.client.dao.MeasurementDao;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuButtons {
    public void buttonsGenerator(List<Integer> data, JPanel rowHolderPanel){
        System.out.println(data.size());
        Integer licznik = 0;
        zewn: while(true){
            JPanel panel = new JPanel(new GridLayout(0,4));
            panel.setBackground(new Color(33, 59, 68));
            for(int x = 0; x<4;x++){
                panel.add(new JButton(String.valueOf(data.get(licznik))));
                //TODO ActionListener
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
