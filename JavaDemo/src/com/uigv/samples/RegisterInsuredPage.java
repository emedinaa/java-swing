package com.uigv.samples;

import com.uigv.samples.data.AppData;
import com.uigv.samples.model.InsuredEntity;
import com.uigv.samples.ui.BasePage;
import com.uigv.samples.ui.CustomDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class RegisterInsuredPage extends BasePage {

    private final int DOCUMENT_MAX=8;
    private JPanel panel1;
    private JLabel jLabelTitile;
    private JTextField nameTextField;
    private JTextField lastnameTextField;
    private JButton registrarButton;
    private JButton backButton;
    private JTextField dniTextField;
    private JSpinner spinnerAge;

    private int age=0;
    private String dni;
    private String name, lastname;

    public RegisterInsuredPage(){
        setUp(panel1);

        SpinnerModel spinnerModel = new SpinnerNumberModel(18, //initial value
                0, //min
                100, //max
                1);//step
        spinnerAge.setModel(spinnerModel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToParent();
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateForm()){
                    saveInsured();
                }
            }
        });
    }

    private void saveInsured(){
        InsuredEntity insuredEntity= new InsuredEntity();
        insuredEntity.setDni(dni);
        insuredEntity.setName(name);
        insuredEntity.setLastName(lastname);
        insuredEntity.setAge(age);
        AppData.getInstance().getInsuredProvider().addInsured(insuredEntity);

        CustomDialog.show(this,"Asegurado agregado !");
    }

    private boolean validateForm(){
        dni= dniTextField.getText().trim();
        name= nameTextField.getText().trim();
        lastname= lastnameTextField.getText().trim();
        age= Integer.parseInt(spinnerAge.getValue().toString());

        if(dni.isEmpty()){
            return false;
        }

        if(name.isEmpty()){
            return false;
        }

        if(lastname.isEmpty()){
            return false;
        }

        if(dni.length()<DOCUMENT_MAX){
            return false;
        }

        return true;
    }


}
