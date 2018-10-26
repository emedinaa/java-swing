package com.uigv.samples.ui;

import com.uigv.samples.MyPage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eduardomedina on 10/25/18.
 */
public abstract class BasePage extends JFrame{
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 500;

    protected void backToParent(){
        Navigation.goToPage(this, new MyPage());
    }

    protected void setUp(Container container){
        setSize(WIDTH, HEIGHT);
        setContentPane(container);
        setLocationRelativeTo(null);
    }
}
