package com.java2311.multithreading2311;


import com.java2311.multithreading2311.views.MainWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new MainWindow();
            }
        });
    }
}
