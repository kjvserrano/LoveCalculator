package main.loveServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoveServer {
	private ServerSocket listenSocket;
	
	public LoveServer() throws IOException{
		listenSocket = new ServerSocket(5000);
		//listenSocket.setSoTimeout(10000);
	}
	
	public LoveServer(ServerSocket serverSocket) throws IOException{
		this.listenSocket = serverSocket;
		//this.listenSocket.setSoTimeout(1000);
	}
	
	public void startServer(LoveAlgorithm algo){
		System.out.println("[INFO] Server Accepting Connections");
		while(true){
			try {
				Socket clientSocket = listenSocket.accept();
				LoveHandler loveHandler = new LoveHandler(clientSocket, algo);
				loveHandler.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
