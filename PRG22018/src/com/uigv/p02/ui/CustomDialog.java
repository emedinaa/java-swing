/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uigv.p02.ui;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author emedinaa
 */
public class CustomDialog {
    public static void show(Component parent, String message){
           JOptionPane.showMessageDialog(parent, message);
    }
}
