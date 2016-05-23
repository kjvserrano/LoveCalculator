package loveServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoveHandler extends Thread {
	private Socket clientSocket = null;
	private DataInputStream clientInputStream;
	private DataOutputStream clientOutputStream;
	
	public LoveHandler(Socket clientSocket) throws IOException{
		this.clientSocket = clientSocket;
		clientInputStream = new DataInputStream(this.clientSocket.getInputStream());
		clientOutputStream = new DataOutputStream(this.clientSocket.getOutputStream());
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
		String message = clientInputStream.readUTF();
		System.out.println(message);
		return message;
	}
	
	public void sendToClient(String message) throws IOException{
		clientOutputStream.writeBytes(message);
	}
	
	public void closeConnection() throws IOException{
		clientSocket.close();
	}
}
