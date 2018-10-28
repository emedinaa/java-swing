package com.uigv.samples;

import com.uigv.samples.data.AppData;
import com.uigv.samples.data.CustomListModel;
import com.uigv.samples.data.InsuredProvider;
import com.uigv.samples.data.MedicalConsProvider;
import com.uigv.samples.model.InsuredEntity;
import com.uigv.samples.model.MedicalConsEntity;
import com.uigv.samples.model.ReportEntity;
import com.uigv.samples.ui.BasePage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class ReportPage  extends BasePage{

    private JButton backButton;
    private JLabel jLabelTitile;
    private JPanel container;
    private JTable table1;

    private List<ReportEntity> reportEntityList;
    private MedicalConsProvider medicalConsProvider;
    private InsuredProvider insuredProvider;

    public ReportPage(){
        medicalConsProvider= AppData.getInstance().getMedicalConsrovider();
        insuredProvider= AppData.getInstance().getInsuredProvider();
        setUp(container);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToParent();
            }
        });

        loadData();
    }

    private void loadData(){

        // Column Names
        String[] columnNames = { "Apellidos y Nombres", "Age","Consultas","Monto"};
        buildData();

        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (ReportEntity reportEntity:reportEntityList) {
            String[] item = { reportEntity.getFullName(), String.valueOf(reportEntity.getAge()),
                    String.valueOf(reportEntity.getConsultation()),
            "S/."+String.valueOf(reportEntity.getTotalAmount())};
            model.addRow(item);
        }
        table1.setModel(model);
    }

    private void buildData(){
        reportEntityList= new ArrayList<>();
        final List<InsuredEntity> insuredEntityList= insuredProvider.insureds();
        for (InsuredEntity item:insuredEntityList) {
            List<MedicalConsEntity> medicalConsultationPageList= medicalConsProvider.medicalConsultationListByDni(item.getDni());
            String fullName= item.getLastName()+" "+item.getName();
            int age= item.getAge();
            int count= medicalConsultationPageList.size();
            Double totalAmount=0.0;
            System.out.println("item fullName "+fullName+"  age "+age+" count "+count);
            for (MedicalConsEntity mc:medicalConsultationPageList){
                totalAmount+= mc.getPayment();
            }
            ReportEntity reportEntity= new ReportEntity();
            reportEntity.setFullName(fullName);
            reportEntity.setAge(age);
            reportEntity.setConsultation(count);
            reportEntity.setTotalAmount(totalAmount);
            reportEntityList.add(reportEntity);
        }
    }
}
