package main.loveClient;

import java.io.IOException;

public class LoveClient {
	LoveClientConnection clientConn;
	
	public LoveClient(){
		clientConn = new LoveClientConnection("127.0.0.1", 5000);
	}
	
	public String loveQuery(){
		String message = "";
		try {
			clientConn.connect();
			clientConn.sendToServer("Hello?");
			message = clientConn.readFromServer();
			clientConn.closeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
