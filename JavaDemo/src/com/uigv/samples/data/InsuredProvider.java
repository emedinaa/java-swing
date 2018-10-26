package com.uigv.samples.data;

import com.sun.istack.internal.NotNull;
import com.uigv.samples.model.InsuredEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class InsuredProvider {

    private List<InsuredEntity> insuredEntityList;

    public InsuredProvider() {
        this.insuredEntityList = new ArrayList<>();
    }

    public void addInsured(@NotNull InsuredEntity insuredEntity){
        insuredEntityList.add(insuredEntity);
    }

    public void removeInsured(@NotNull InsuredEntity insuredEntity){
        insuredEntityList.remove(insuredEntity);
    }

    public List<InsuredEntity> insureds(){
        return insuredEntityList;
    }

    public void clear(){
        insuredEntityList.clear();
    }
}
