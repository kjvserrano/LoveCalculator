package main.loveServer;

import java.io.IOException;

public class MPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LoveServer server = new LoveServer();
		
		if(args[0].equalsIgnoreCase("flames")){
			System.out.println("[INFO] Server starting with FLAMES algorithm");
			server.startServer(LoveAlgorithm.FLAMES);
		}else if(args[0].equalsIgnoreCase("truelove")){
			System.out.println("[INFO] Server starting with TRUELOVE algorithm");
			server.startServer(LoveAlgorithm.TRUELOVE);
		}else{
			System.out.println("[WARN] Unknown Parameter: Defaulted to Flames Algorithm");
			System.out.println("[INFO] Server starting with FLAMES algorithm");
			server.startServer(LoveAlgorithm.FLAMES);
		}
			
		
	}

}
