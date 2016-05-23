package main.loveClient;

import java.util.Scanner;

public class LoveClientGUI {
	Scanner scanner = new Scanner(System.in);
	
	public String requestForInput(){
		String input = "";
		InputValidator inputValidator = new InputValidator();
		
		while(inputValidator.validateInput(input)==false){
			System.out.println("Enter two names to see their love compatibility (eg Bob,Joe): ");
			input = scanner.nextLine();
			if(inputValidator.validateInput(input)==false){
				System.out.println("Invalid input, please try again.");
			}
		}
		
		return input;
	}
	
	public void printResult(String result){
		System.out.println("Result: " + result);
	}
}
