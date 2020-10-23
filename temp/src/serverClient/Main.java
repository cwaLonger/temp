package serverClient;

public class Main extends Thread{
	public static void main(String[] args){
		Client c = new Client();
		c.sendMessage("aaa\nbbb\nccc\nddd\nexit");
	}
	
}
