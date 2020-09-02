package com.dsantanaleal.windowstools.processes.front;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Start extends JFrame {

    private Container container = this.getContentPane();
    private GroupLayout layout = new GroupLayout(container);
    private JButton botonListarProcesos = new JButton("Listar procesos");
    DefaultTableModel model = new DefaultTableModel(10, 10);
    private JTable tablaProcesos = new JTable(model);

    private Start() {
        loadComponents();
    }

    public void loadComponents() {
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        model.setValueAt("hOLA", 1, 1);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botonListarProcesos)
                        .addComponent(tablaProcesos)
                )
        );
    }


    public static Start init() {
        Start app = new Start();
        app.pack();
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return app;
    }

    public static void main(String[] args) {
        Start.init();
    }
}
