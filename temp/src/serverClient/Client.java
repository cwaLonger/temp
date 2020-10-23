package serverClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public Client(){
		try{
			s = new Socket("localhost", 9091);
			System.out.println("[Console] client is connected");
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch(IOException e){
			System.out.println("[Console] client connection failed");
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String str){
		try {
			bw.append(str + "\r\n");
			bw.flush();
			System.out.println("[Console] message successfully send : " + str);
			String recievedStr;
			while(!(recievedStr=br.readLine()).equals("exit"))
				System.out.println(recievedStr);
			System.out.println("[Console] message successfully recieved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
