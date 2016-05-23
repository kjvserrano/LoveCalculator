package main.loveClient;

public class InputValidator {
	public boolean validateInput(String input){
		
		String[] inputList = input.split(",");
		if(inputList.length!= 2){
			return false;
		}
		
		return true;
	}
}
