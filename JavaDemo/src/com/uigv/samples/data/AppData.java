package com.uigv.samples.data;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class AppData {

    private static AppData instance;
    private static InsuredProvider insuredProvider;
    private static MedicalConsProvider medicalConsProvider;

    private AppData(){
        insuredProvider= new InsuredProvider();
        medicalConsProvider= new MedicalConsProvider();
    }

    public static AppData getInstance(){
        if(instance == null){
            instance = new AppData();
        }
        return instance;
    }

    public InsuredProvider getInsuredProvider(){return insuredProvider;}

    public MedicalConsProvider getMedicalConsrovider(){return medicalConsProvider;}

}
