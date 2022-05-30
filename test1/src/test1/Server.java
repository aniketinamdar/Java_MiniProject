package test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import com.mysql.cj.xdevapi.Statement;

import test1.Dtbs;

class Server extends Thread {
	protected ServerSocket serv = null;
	protected Socket sock = null;
	Server() {
		try {
			serv = new ServerSocket(6666);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		while (true) {
			try {
				System.out.println("waiting for clients...");
				sock = serv.accept();
				new conn(sock).start();
			} catch (SocketTimeoutException se) {
				continue;
			} catch (Exception e) {
//				e.printStackTrace();
				continue;
			}
		}
	} // run method ends
	
} // server class ends


class conn extends Thread {
	protected Socket client;
	conn(Socket sock) {
		this.client = sock;
	}
	
	@Override
	public void run() {
		System.out.println(client.toString() + " connected");
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Dtbs db = new Dtbs();
		System.out.println("database connectivity established");
		try {
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			System.out.println("all good");
			String s, name, email, pass;
			while (client.isConnected()) {
				// do all the io with client here
				
				s = dis.readUTF();
				System.out.println(s);
				if (s.equals("signup")) {
					System.out.println("...");
					name = dis.readUTF();
					System.out.println(name);
					email = dis.readUTF();
					System.out.println(email);
					pass = dis.readUTF();
					System.out.println(pass);
					db.exec("INSERT INTO account VALUES('" + email + "','" + name + "','" + pass + "');");
					// INSERT INTO account VALUES('email','name','pass');
					dos.writeUTF("ok");
					continue;
				}
				if (s.equals("login")) {
					System.out.println("---");
					email = dis.readUTF();
					System.out.println(email);
					pass = dis.readUTF();
					System.out.println(pass);
					String[] temp = db.qry("SELECT * FROM account WHERE Email='" + email + "';");
					if (pass.equals(temp[0])) {
						dos.writeUTF("ok");
						dos.writeUTF(temp[1]);
					} else {
						dos.writeUTF("not ok");
					}
					continue;
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		try {
			System.out.println(client.toString() + " disconnected");
			dis.close();
			dos.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // run method ends
	
} // thread1 class ends




//System.out.println(s);
//dos.writeUTF("EHE TE NANDAYO!!!");
//Thread.sleep(1000);