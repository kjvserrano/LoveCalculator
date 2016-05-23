package loveServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoveServer {
	private ServerSocket listenSocket;
	
	public LoveServer() throws IOException{
		listenSocket = new ServerSocket(5000);
		listenSocket.setSoTimeout(1000);
	}
	
	public LoveServer(ServerSocket serverSocket) throws IOException{
		this.listenSocket = serverSocket;
		this.listenSocket.setSoTimeout(1000);
	}
	
	public void startServer() throws IOException{
		while(true){
			Socket clientSocket = listenSocket.accept();
			LoveHandler loveHandler = new LoveHandler(clientSocket);
			loveHandler.start();
		}
	}

}
