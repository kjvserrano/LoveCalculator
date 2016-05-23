package loveClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LoveClientConnection {
	Socket connSocket;
	String serverName;
	int port;
	private DataInputStream inFromServer;
	private DataOutputStream outToServer;
	
	public LoveClientConnection(String serverName, int port){
		this.connSocket = new Socket();
		this.serverName = serverName;
		this.port = port;
	}

	public void connect() throws IOException{
		System.out.println("[INFO] Connecting to Server");
		
		connSocket.connect(new InetSocketAddress(serverName, port));
		outToServer = new DataOutputStream(connSocket.getOutputStream());
		inFromServer = new DataInputStream(connSocket.getInputStream());
	}
	
	public void sendToServer(String message) throws IOException{
		System.out.println("[INFO] Sending message to server");
		outToServer.writeBytes(message);
	}
	
	public String readFromServer() throws IOException{
		System.out.println("[INFO] Waiting for reply");
		String message = inFromServer.readUTF();
		return message;
	}
	
	public void closeConnection() throws IOException{
		connSocket.close();
	}
}
