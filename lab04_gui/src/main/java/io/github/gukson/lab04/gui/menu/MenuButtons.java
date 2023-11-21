package io.github.gukson.lab04.gui.menu;

import io.github.gukson.lab04.gui.CoreUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuButtons {
    public void buttonsGenerator(List<Integer> data, JPanel rowHolderPanel, MenuGUI menuGUI){
        System.out.println(data.size());
        Integer licznik = 0;
        zewn: while(true){
            JPanel panel = new JPanel(new GridLayout(0,4));
            panel.setBackground(new Color(33, 59, 68));
            for(int x = 0; x<4;x++){
                JButton button = new JButton(String.valueOf(data.get(licznik)));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(menuGUI.getContentPane());
                        coreui.toogleCharts();
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
