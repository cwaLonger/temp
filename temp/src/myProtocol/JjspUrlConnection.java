package myProtocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.StringTokenizer;

@SuppressWarnings("unused")
public class JjspUrlConnection {
	private String url;
	private int port = 8080;
	private String detailUrl;
	
	private StringTokenizer st;
	private Socket s;
	private BufferedReader br;
	private BufferedWriter bw;
	
	
	public JjspUrlConnection(String url) {
		try {
			checkValue(url);
			
			s = new Socket(this.url, port);
			System.out.println("[Console] client is connected");
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		} catch (JjspNotFormatException e) {
			e.printStackTrace();
		} catch(IOException e){
			System.out.println("[Console] client connection failed");
			e.printStackTrace();
		} catch(NullPointerException e) {
			System.out.println("url : " + this.url);
			System.out.println("port : " + port);
			e.printStackTrace();
		}
		
		
	}
	
	private void checkValue(String url) throws JjspNotFormatException {
		if(url.isEmpty())
			throw new JjspNotFormatException(url, "Input value is null");
		st = new StringTokenizer(url, ":");
		switch (st.countTokens()) {
		case 1:
			this.url = url;
			break;
		case 2:
			try {
				String first = st.nextToken();
				if(first.equals("jjsp")) {
					this.url = st.nextToken();
				}
				else {
					int second = Integer.valueOf(st.nextToken());
					this.url = first;
					port = second;
				}
			} catch(NumberFormatException e) {
				throw new JjspNotFormatException(url, JjspNotFormatException.PortError);
			}
			break;
		case 3 :
			try {
				if(!st.nextToken().equals("jjsp"))
					throw new JjspNotFormatException(url, JjspNotFormatException.ProtocolError);
				String first = st.nextToken();
				int second = Integer.valueOf(st.nextToken());
				this.url = first;
				port = second;
			} catch(NumberFormatException e) {
				throw new JjspNotFormatException(url, JjspNotFormatException.PortError);
			}
			break;
		default:
			throw new JjspNotFormatException(url, "Check url if it has more than two ':'.");
		}
		
		System.out.println(this.url);
		System.out.println(port);
	}

	public void sendMessage(String str){
		try {
			bw.append(str + "\r\n");
			bw.flush();
			System.out.println("[Console] message successfully send : " + str);
			String recievedStr;
			while(!(recievedStr=br.readLine()).equals("EXIT"))
				System.out.println(recievedStr);
			System.out.println("[Console] message successfully recieved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		JjspUrlConnection juc = new JjspUrlConnection("jjsp:localhost:9091");
		juc.sendMessage("aaa\nbbb\nccc\nddd\nexit");
	}
}
