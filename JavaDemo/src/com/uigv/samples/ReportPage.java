package com.uigv.samples;

import com.uigv.samples.data.AppData;
import com.uigv.samples.data.CustomListModel;
import com.uigv.samples.model.InsuredEntity;
import com.uigv.samples.ui.BasePage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class ReportPage  extends BasePage{

    private JButton backButton;
    private JLabel jLabelTitile;
    private JPanel container;
    private JTable table1;

    private List<InsuredEntity> insuredEntityList;

    public ReportPage(){
        setUp(container);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToParent();
            }
        });

        loadInsureds();
    }

    private void loadInsureds(){
        insuredEntityList= AppData.getInstance().getInsuredProvider().insureds();
        /*DefaultListModel<InsuredEntity> modelList=new DefaultListModel<>();

        for (InsuredEntity insuredEntity:insuredEntityList) {
            modelList.addElement(insuredEntity);
        }*/

        /*CustomListModel customListModel= new CustomListModel(insuredEntityList);
        list1.setModel(customListModel);*/

        // Column Names
        String[] columnNames = { "Nombre", "Apellidos", "DNI","Age" };

        String[] item1 = {"Eduardo José","Medina Alfaro","40898479","18"};
        String[] item2 = {"José Eduado","Medina Pacheco","40898479","80"};

        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (InsuredEntity insuredEntity:insuredEntityList) {
            String[] item = { insuredEntity.getLastName(), insuredEntity.getName(),insuredEntity.getDni(),
            String.valueOf(insuredEntity.getAge())};
            model.addRow(item);
        }
        //model.addRow(item1);
        //model.addRow(item2);
        table1.setModel(model);
    }
}
