package main.loveClient;

import java.util.Scanner;

public class LoveClientGUI {
	Scanner scanner = new Scanner(System.in);
	
	public String requestForInput(){
		System.out.println("Enter two names to see their love compatibility (eg Bob,Joe): ");
		return scanner.nextLine();
	}
	
	public void printResult(String result){
		System.out.println("Result: " + result);
	}
}
