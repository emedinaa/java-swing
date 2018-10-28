package com.uigv.samples;

import com.uigv.samples.data.AppData;
import com.uigv.samples.model.InsuredEntity;
import com.uigv.samples.model.MedicalConsEntity;
import com.uigv.samples.ui.BasePage;
import com.uigv.samples.ui.CustomDialog;

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

    private final int COUNT_MAX=3;

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
        loadInsureds();
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

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateForm()){
                    saveMedicalConsultation();
                }
            }
        });
    }

    private boolean validateForm(){
        if(currentInsured==null){
            //TODO mensaje de error
            return false;
        }
        if(textArea1.getText().isEmpty()){
            return false;
        }
        return true;
    }

    private void saveMedicalConsultation(){
        if(currentInsured!=null){
            int count= AppData.getInstance().getMedicalConsrovider().medicalConsultationsByDni(currentInsured.getDni());
            int age= currentInsured.getAge();
            String dni= currentInsured.getDni();
            int nCount= count+1;
            Double payment= paymentByAge(age,nCount);

            MedicalConsEntity medicalConsEntity= new MedicalConsEntity();
            medicalConsEntity.setInsuredDNI(dni);
            medicalConsEntity.setPayment(payment);
            medicalConsEntity.setCount(nCount);

            System.out.println("MedicalConsEntity "+medicalConsEntity.toString());
            AppData.getInstance().getMedicalConsrovider().addMedicalCons(medicalConsEntity);

            CustomDialog.show(this,"Consulta agregada !");
        }
    }

    private Double paymentByAge(int age,int count){
        System.out.println("paymentByAge age "+age+" count "+count);
       Double amount=0.0;
       if(age>=0 && age<=18){
           amount= 60.0 + additionalPayment(0,60.0,count);
       }else if(age>=19 && age<=30){
           amount= 80.0 + additionalPayment(1,80.0,count);
       }else if(age>=31 && age<=50){
           amount= 100.0 + additionalPayment(2,100.0,count);
       }else{
           amount= 120.0 + additionalPayment(3,120.0,count);
       }
       return  amount;
    }

    private Double additionalPayment(int option, Double amount,int count){
        System.out.println("additionalPayment option "+option+" amount "+amount+" count "+count);
        if(count<=COUNT_MAX){
            return 0.0;
        }
        Double percent=0.0;
        switch (option){
            case 0:
                percent= amount*0.10;
                break;
            case 1:
                percent= amount*0.09;
                break;
            case 2:
                percent= amount*0.08;
                break;
            case 3:
                percent= amount*0.07;
                break;
        }
        System.out.println("percent "+percent);
        return percent;
    }

    private void loadInsureds(){
        insuredEntityList= AppData.getInstance().getInsuredProvider().insureds();
        for (InsuredEntity insuredEntity:insuredEntityList) {
            comboBox1.addItem(insuredEntity.getLastName()+" "+insuredEntity.getName());
        }
    }
}
