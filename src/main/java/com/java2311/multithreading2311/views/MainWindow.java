package com.java2311.multithreading2311.views;

import com.java2311.multithreading2311.Const.ButtonNames;
import com.java2311.multithreading2311.controllers.ButtonActionListener;
import com.java2311.multithreading2311.model.TaskRunnable;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainWindow extends JFrame {


    public MainWindow() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        ProgressBarPanel progressBarPanel = new ProgressBarPanel(4);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton startButton = new JButton(ButtonNames.START);
        startButton.setActionCommand("Start");

        JButton stopButton = new JButton(ButtonNames.STOP);
        stopButton.setActionCommand("Stop");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        add(progressBarPanel);
        add(buttonPanel);
        setVisible(true);
      //  -------------------------------------------------------------
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < progressBarPanel.getProgressBars().size(); i++) {
            threads.add(new Thread(new TaskRunnable(progressBarPanel.getProgressBars().get(i))));
        }

        startButton.addActionListener(new ButtonActionListener(progressBarPanel, threads));
        stopButton.addActionListener(new ButtonActionListener(progressBarPanel, threads));

    }
}
