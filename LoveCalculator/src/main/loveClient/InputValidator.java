package main.loveClient;

public class InputValidator {
	public boolean validateInput(String input){
		
		String[] inputList = input.split(",");
		if(inputList.length!= 2){
			return false;
		}
		
		for(String retval:inputList){
			//if input is blank
			if(retval.length()==0){
				return false;
			}
			
			//if input contains non-alpha
			if(!retval.matches("[a-zA-Z]+")){
				return false;
			}
		}
		
		return true;
	}
}
