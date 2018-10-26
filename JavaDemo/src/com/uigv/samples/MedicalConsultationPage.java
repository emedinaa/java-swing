package com.uigv.samples;

import com.uigv.samples.data.AppData;
import com.uigv.samples.model.InsuredEntity;
import com.uigv.samples.ui.BasePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class MedicalConsultationPage  extends BasePage{


    private JPanel container;
    private JButton guardarButton;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JButton backButton;
    private JLabel jLabelTitile;

    private List<InsuredEntity> insuredEntityList;
    private InsuredEntity currentInsured;

    public MedicalConsultationPage(){
        setUp(container);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToParent();
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb= (JComboBox) e.getSource();
                int position=cb.getSelectedIndex();
                if(insuredEntityList!=null && insuredEntityList.size()>position){
                    currentInsured= insuredEntityList.get(position);
                }
            }
        });

        loadInsureds();
    }

    private void loadInsureds(){
        insuredEntityList= AppData.getInstance().getInsuredProvider().insureds();
        for (InsuredEntity insuredEntity:insuredEntityList) {
            comboBox1.addItem(insuredEntity.getLastName()+" "+insuredEntity.getName());
        }
    }
}
