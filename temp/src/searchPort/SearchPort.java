package searchPort;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

public class SearchPort {
	private final int LAST_PORT_NUM = 65535;
	private final String IP_ADDRESS = "175.113.50.37";
//	private final String IP_ADDRESS = "127.0.0.1";
	
	private int index = 0;
	Vector<Integer> successV = new Vector<Integer>();
	Vector<Integer> nonsuccessV = new Vector<Integer>();
	
	public SearchPort(){
		for(int i = 0 ; i <= LAST_PORT_NUM ; i++){
			new Thread(){
				int port;
				Socket s;
				public void run(){
					try {
						s = new Socket(IP_ADDRESS, port);
						System.out.println("Connection Success in port : " + port);
						successV.add(port);
						System.out.println(successV.size() + " " + nonsuccessV.size());
					} catch (UnknownHostException e) {
						//System.out.println("Connection Failed in port : " + port + " and Error is : " + e.getMessage());
						nonsuccessV.add(port);
					} catch (IOException e) {
						//System.out.println("Connection Failed in port : " + port + " and Error is : " + e.getMessage());
						nonsuccessV.add(port);
					} finally {
						addIndex();
						if(index == LAST_PORT_NUM)
							printResult();
						if(s != null && !s.isClosed()) {
							try {
									s.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				
				public Thread setPort(int port){
					this.port = port;
					return this;
				}
			}.setPort(i).start();
		}
	}
	
	public static void main(String[] args){
		new SearchPort();
	}
	
	private synchronized void addIndex(){
		index++;
	}
	
	private void printResult() {
		System.out.println(successV.size() + " : " + nonsuccessV.size());		
	}
}
