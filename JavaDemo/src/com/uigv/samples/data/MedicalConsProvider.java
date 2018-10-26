package com.uigv.samples.data;

import com.sun.istack.internal.NotNull;
import com.uigv.samples.model.InsuredEntity;
import com.uigv.samples.model.MedicalConsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class MedicalConsProvider {

    private List<MedicalConsEntity> medicalConsEntityList;

    public MedicalConsProvider() {
        this.medicalConsEntityList = new ArrayList<>();
    }

    public void addMedicalCons(@NotNull MedicalConsEntity medicalConsEntity){
        medicalConsEntityList.add(medicalConsEntity);
    }

    public void removeMedicalCons(@NotNull MedicalConsEntity medicalConsEntity){
        medicalConsEntityList.remove(medicalConsEntity);
    }

    public List<MedicalConsEntity> medicalconsultations(){
        return medicalConsEntityList;
    }

    public void clear(){
        medicalConsEntityList.clear();
    }
}
