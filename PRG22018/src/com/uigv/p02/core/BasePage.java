/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uigv.p02.core;

import com.uigv.p02.HomeJFrame;
import javax.swing.JFrame;

/**
 *
 * @author emedinaa
 */
public abstract class BasePage extends JFrame{
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 500;
    
     protected void backToParent(){
        Navigation.goToPage(this, new HomeJFrame());
    }

   protected void setUp(){
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
    }
}
