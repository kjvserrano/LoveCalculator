package loveServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoveHandler extends Thread {
	private Socket clientSocket = null;
	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	
	public LoveHandler(Socket clientSocket) throws IOException{
		this.clientSocket = clientSocket;
		inFromClient = new DataInputStream(this.clientSocket.getInputStream());
		outToClient = new DataOutputStream(this.clientSocket.getOutputStream());
	}
	
	public void run(){
		String message = "";
		try {
			message = readFromClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handleRequest(message);

	}
	
	public void handleRequest(String message){
		//ADD Calculator Code Here
		try {
			sendToClient(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readFromClient() throws IOException{
		String message = inFromClient.readUTF();
		return message;
	}
	
	public void sendToClient(String message) throws IOException{
		outToClient.writeBytes(message);
	}
	
	public void closeConnection() throws IOException{
		clientSocket.close();
	}
}
