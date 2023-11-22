package io.github.gukson.lab04.gui.menu;

import io.github.gukson.lab04.client.dao.MeasurementDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class MenuGUI extends JFrame {
    private final JScrollPane scrollPane;
    private JPanel contentPane, dataSection, outerPanel;
    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));

    public MenuGUI(MeasurementDao measurementDao)  {
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setBackground(new Color(33, 59, 68));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        menuLabel.setForeground(new Color(254, 255, 255));
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuLabel.setBounds(6, 6, 888, 37);
        contentPane.add(menuLabel);

        this.dataSection = new JPanel();
        this.dataSection.setBorder(null);
        dataSection.setBounds(6, 55, 888, 320);
        dataSection.setOpaque(false);
        contentPane.add(dataSection);

        this.outerPanel = new JPanel(new BorderLayout());
        this.dataSection.add(this.outerPanel);
        this.outerPanel.add(rowHolderPanel, BorderLayout.PAGE_START);
        this.scrollPane = new JScrollPane(outerPanel);

        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.dataSection.setLayout(new BorderLayout());
        this.dataSection.add(scrollPane, BorderLayout.CENTER);
        dataSection.setBackground(new Color(33, 59, 68));
        this.rowHolderPanel.setBackground(new Color(33, 59, 68));

        MenuButtons menuButtons = new MenuButtons();
        try{
            menuButtons.buttonsGenerator(measurementDao.getAllStationId(), rowHolderPanel, MenuGUI.this);
        }
        catch (SQLException ignored){}

    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }
}
