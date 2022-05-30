package com.example.collegeconnect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class S {
    public static Socket sock = null;
    public static DataInputStream dis = null;
    public static DataOutputStream dos = null;
    public static String name = "";

    public static void connect() {
        new thrd1().start();
    }

    public static class thrd1 extends Thread {
        public void run() {
            try {
                sock = new Socket("192.168.69.225", 6666);
                dos = new DataOutputStream(sock.getOutputStream());
                dis =new DataInputStream(sock.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


