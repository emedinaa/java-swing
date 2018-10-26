package com.uigv.samples;

import com.uigv.samples.ui.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panel1;
    private JButton registrarAseguradoButton;
    private JButton registrarConsultaButton;
    private JButton reporteButton;

    public App() {

        final JFrame current= new JFrame("App");
        /*
             JOptionPane.showMessageDialog(null, "Hello World");

                JFrame jFrame= new JFrame("MedicalConsulttionPage");
                JFrame current= new JFrame("App");
                Navigation.goToPage(current,jFrame);
         */
        registrarAseguradoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Hello World");

                JFrame jFrame= new JFrame("RegisterInsuredPage");
                Navigation.goToPage(current,jFrame);
            }
        });

        registrarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Hello World");
                JFrame jFrame= new JFrame("MedicalConsultationPage");
                Navigation.goToPage(current,jFrame);
            }
        });

        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame= new JFrame("ReportPage");
                //JOptionPane.showMessageDialog(null, "Hello World");
                Navigation.goToPage(current,jFrame);
            }
        });
    }

    public static void main(String[] args) {
        JPanel jPanel = new App().panel1;
        jPanel.setPreferredSize(new Dimension(480, 320));
        JFrame jFrame = new JFrame("App");
        jFrame.setSize(480,320);
        jFrame.setContentPane(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
