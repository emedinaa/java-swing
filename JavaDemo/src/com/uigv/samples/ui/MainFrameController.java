package com.uigv.samples.ui;

import com.uigv.samples.MyPage;

/**
 * Created by eduardomedina on 10/25/18.
 */
public class MainFrameController {

    private MyPage myPage;

    public MainFrameController() {
        initComponents();
    }

    private void initComponents() {
        myPage = new MyPage();
    }

    public void showMainFrameWindow() {
        myPage.setVisible(true);
    }

}
