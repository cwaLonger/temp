package myProtocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket listener;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public Server(){
		try{
			listener = new ServerSocket(9091);
			System.out.println("[Console] server is ready");
			Socket s = listener.accept();
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			
			new Thread() {
				@Override
				public void run() {
					int i = 0;
					String str;
					try {
						while(!(str = br.readLine()).equals("exit")){
							System.out.println("index : " + i++ + " : " + str);
							try {
								bw.append("From Server : " + str.toUpperCase() + "\r\n");
								bw.flush();
							} catch(IOException e){
								System.out.println("[Console] server is closed");
								e.printStackTrace();
							}
						}
						bw.append("From Server : " + str.toUpperCase() + "\r\n");
						bw.flush();
						System.out.println("Client send exit message");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
		} catch(IOException e){
			System.out.println("[Console] server is closed");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		new Server();
	}
}
