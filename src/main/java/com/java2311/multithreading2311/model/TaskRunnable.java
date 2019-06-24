package com.java2311.multithreading2311.model;


import javax.swing.*;

public class TaskRunnable implements Runnable{
    private JProgressBar progressBar;
    private int currentValue = 0;

    public TaskRunnable(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            if(currentValue > progressBar.getMaximum()) {
                currentValue = progressBar.getMinimum();
            }
            progressBar.setValue(currentValue++);
        }
    }

}
