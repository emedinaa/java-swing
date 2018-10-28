package com.uigv.samples.data;

import com.uigv.samples.model.InsuredEntity;

import javax.swing.*;
import java.util.List;

public class CustomListModel extends AbstractListModel {

    private List<InsuredEntity> customList;

    public CustomListModel(List<InsuredEntity> list) {
        customList= list;
    }

    @Override
    public int getSize() {
        return customList.size();
    }

    @Override
    public Object getElementAt(int index) {
        InsuredEntity insuredEntity= customList.get(index);
        return insuredEntity;
    }
}
