/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uigv.p02.core;

import javax.swing.JFrame;

/**
 *
 * @author emedinaa
 */
public class Navigation {
   
    public static void goToPage(JFrame origin, JFrame destiny){
        origin.setVisible(false);
        destiny.setVisible(true);
        origin.dispose();
    }
}
