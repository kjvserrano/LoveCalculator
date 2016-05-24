package main.loveClient;

import java.io.IOException;

public class LoveClient {
	LoveClientConnection clientConn;
	LoveClientGUI loveClientGUI = new LoveClientGUI();
	
	public LoveClient(){
		clientConn = new LoveClientConnection("127.0.0.1", 5000);
	}
	
	public void start(){
		String input = loveClientGUI.requestForInput();
		String result = loveQuery(input);
		loveClientGUI.printResult(result);
	}
	
	public String loveQuery(String message){
		try {
			clientConn.connect();
			clientConn.sendToServer(message);
			message = clientConn.readFromServer();
			clientConn.closeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
