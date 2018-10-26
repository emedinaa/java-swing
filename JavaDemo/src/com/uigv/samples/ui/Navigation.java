package com.uigv.samples.ui;

import javax.swing.*;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class Navigation {

    public static void goToPage(JFrame origin, JFrame destiny){
        origin.setVisible(false);
        destiny.setVisible(true);
        origin.dispose();
    }
}
