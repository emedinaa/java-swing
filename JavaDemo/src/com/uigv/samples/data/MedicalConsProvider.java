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

    public int medicalConsultationsByDni(@NotNull String dni){
        if(medicalConsEntityList!=null && medicalConsEntityList.isEmpty()){
            return 0;
        }
        int count=0;
        for (MedicalConsEntity item :medicalConsEntityList) {
            if(item.getInsuredDNI().equals(dni)){
                count++;
            }
        }
        return count;
    }

    public List<MedicalConsEntity> medicalConsultationListByDni(@NotNull String dni){
        List<MedicalConsEntity> mcList= new ArrayList<>();
        for (MedicalConsEntity item :medicalConsEntityList) {
            if(item.getInsuredDNI().equals(dni)){
                mcList.add(item);
            }
        }
        return mcList;
    }

    public void clear(){
        medicalConsEntityList.clear();
    }
}
