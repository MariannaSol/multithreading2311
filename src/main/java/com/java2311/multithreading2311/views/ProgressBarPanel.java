package com.java2311.multithreading2311.views;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProgressBarPanel extends JPanel {

    private List<JProgressBar> progressBars = new ArrayList<JProgressBar>();

    public ProgressBarPanel(int n) {

        setLayout(new GridLayout(n, 1));
        setSize(700, 385);

        for (int i = 0; i < n; i++) {
            JProgressBar dynamicProgressBar = new JProgressBar();
            dynamicProgressBar.setSize(500, 20);
            dynamicProgressBar.setStringPainted(true);
            dynamicProgressBar.setForeground(new Color(0xFFCF00));
            dynamicProgressBar.setBackground(new Color(0x8D3072));

            progressBars.add(dynamicProgressBar);

            add(dynamicProgressBar);
        }
    }

    public List<JProgressBar> getProgressBars() {
        return progressBars;
    }
}
