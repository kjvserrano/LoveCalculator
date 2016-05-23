package loveClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LoveClientConnection {
	Socket connSocket;
	private DataInputStream inFromServer;
	private DataOutputStream outToServer;
	
	public LoveClientConnection(){
		this.connSocket = new Socket();
	}

	public void connect(String serverName, int port) throws IOException{
		connSocket.connect(new InetSocketAddress(serverName, port));
		outToServer = new DataOutputStream(connSocket.getOutputStream());
		inFromServer = new DataInputStream(connSocket.getInputStream());
	}
	
	public void sendToServer(String message) throws IOException{
		outToServer.writeBytes(message);
	}
	
	public String readFromServer() throws IOException{
		String message = inFromServer.readUTF();
		return message;
	}
	
	public void closeConnection() throws IOException{
		connSocket.close();
	}
}
