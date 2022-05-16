package com.example.collegeconnect;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Sock {
    public static Socket sck;

    public static void init() {
        try {
            sck = IO.socket("https://apitest2.bijux02.repl.co");
        } catch (URISyntaxException e) {
            System.out.println(e);
            return;
        }
        sck.connect();
    }
}
