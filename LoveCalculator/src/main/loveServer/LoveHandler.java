package main.loveServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoveHandler extends Thread {
	private Socket clientSocket = null;
	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	private LoveCalculator loveCalculator = null;
	
	public LoveHandler(Socket clientSocket, LoveAlgorithm algo) throws IOException{
		System.out.println("[INFO] Client Connected");
		this.clientSocket = clientSocket;
		inFromClient = new DataInputStream(this.clientSocket.getInputStream());
		outToClient = new DataOutputStream(this.clientSocket.getOutputStream());
		
		switch(algo){
		case FLAMES:
			loveCalculator = new FlamesCalculator();
			break;
		case TRUELOVE:
			loveCalculator = new TrueLoveCalculator();
			break;
		}
	}
	
	public void run(){
		handleRequest();

	}
	
	public void handleRequest(){
		String messageIn = "";
		String messageResult = "";
		
		try {
			messageIn = readFromClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ADD Calculator Code Here
		messageResult = loveCalculator.calculate(messageIn.split(",")[0], messageIn.split(",")[1]);
		
		try {
			sendToClient(messageResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readFromClient() throws IOException{
		String message = inFromClient.readUTF();
		System.out.println("[INFO] Received " + message + " from client");
		return message;
	}
	
	public void sendToClient(String message) throws IOException{
		System.out.println("[INFO] Sending " + message + " to client");
		outToClient.writeUTF(message);
	}
	
	public void closeConnection() throws IOException{
		clientSocket.close();
	}
}
