package com.uigv.samples;

import com.uigv.samples.ui.BasePage;
import com.uigv.samples.ui.Navigation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class MyPage extends BasePage {

    private JPanel mainPanel;
    private JButton registrarAseguradoButton;
    private JButton registrarConsultaButton;
    private JButton reporteButton;

    public MyPage(){
        setUp(mainPanel);

        registrarAseguradoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterInsuredPage registerInsuredPage= new RegisterInsuredPage();
                Navigation.goToPage(MyPage.this,registerInsuredPage);
            }
        });


        registrarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicalConsultationPage medicalConsultationPage= new MedicalConsultationPage();
                Navigation.goToPage(MyPage.this,medicalConsultationPage);
            }
        });

        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportPage reportPage= new ReportPage();
                Navigation.goToPage(MyPage.this,reportPage);
            }
        });

    }

}
