package com.example.collegeconnect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class S {
    public static Socket sock = null;
    public static DataInputStream dis = null;
    public static DataOutputStream dos = null;

    public static void connect() {
        new thrd1().start();
    }

    public static class thrd1 extends Thread {
        public void run() {
            try {
                sock = new Socket("192.168.1.27", 6050);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


