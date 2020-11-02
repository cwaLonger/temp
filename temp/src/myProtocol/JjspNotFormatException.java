package myProtocol;

@SuppressWarnings("serial")
public class JjspNotFormatException extends Throwable {
	public static final String PortError = "Check url whether port number is number or not.";
	public static final String ProtocolError = "It must start with jjsp.";
	
	public JjspNotFormatException(String url, String msg) {
		super("[" + url + "] is incorrect protocol. " + msg);
	}
}
