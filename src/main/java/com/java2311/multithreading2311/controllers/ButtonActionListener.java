package com.java2311.multithreading2311.controllers;


import com.java2311.multithreading2311.Const.ButtonNames;
import com.java2311.multithreading2311.model.TaskRunnable;
import com.java2311.multithreading2311.views.ProgressBarPanel;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonActionListener implements ActionListener {

    ProgressBarPanel progressBarPanel;
    List<Thread> threads;

    public ButtonActionListener(ProgressBarPanel progressBarPanel, List<Thread> threads) {
        this.progressBarPanel = progressBarPanel;
        this.threads = threads;
    }

    public ButtonActionListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if( e.getActionCommand().equals(ButtonNames.START)) {

            for (int i = 0; i < threads.size(); i++) {

                if(threads.get(i) == null || threads.get(i).getState() != Thread.State.RUNNABLE) {
                    threads.get(i).start();
                    System.out.println(i);
                    break;
                }
            }
       }

       else if (e.getActionCommand().equals(ButtonNames.STOP)) {
            for (int i = 0; i < threads.size(); i++) {
                if(threads.get(i) != null) {
                    threads.get(i).interrupt();
                    threads.remove(i);
                    break;
                }
            }
           if(threads.size() == 0) {
               for (int i = 0; i < progressBarPanel.getProgressBars().size(); i++) {
                   threads.add(new Thread(new TaskRunnable(progressBarPanel.getProgressBars().get(i))));
               }
           }
       }
    }
}
