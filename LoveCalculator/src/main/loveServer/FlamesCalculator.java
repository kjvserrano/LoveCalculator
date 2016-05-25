package main.loveServer;

public class FlamesCalculator extends LoveCalculator {

	@Override
	public String calculate(String inputA, String inputB) {
		// TODO Auto-generated method stub
		int flamesCount = flamesCount(inputA, inputB);
		String result = flamesParse(flamesResult(flamesCount));
		return result;
	}
	
	private int flamesCount(String paramA, String paramB){
		String inputA = paramA.toLowerCase();
		String inputB = paramB.toLowerCase();
		
		for(Character retChar:inputA.toCharArray()){
			if(inputB.indexOf(retChar)>-1){
				inputA = inputA.replace(retChar.toString(), "");
				inputB = inputB.replace(retChar.toString(), "");
			}
		}
		return inputA.length() + inputB.length();
	}
	
	private char flamesResult(int flamesCount){
		String flamesTextStr = "flames";
		char[] flamesText = flamesTextStr.toCharArray();
		int curPos = 1;
		
		if(flamesCount == 0){
			return 'n';
		}
		
		for (int i = 0; i<5; i++){
			int j = 1;
			
			for(j = 1; j<flamesCount;){
				if(flamesText[curPos-1]!=' '){
					j++;
				}
				
				curPos++;
				if(curPos == 7){
					curPos = 1;
				}
			}
			
			while(flamesText[curPos-1] == ' '){
				curPos++;
				if(curPos == 7){
					curPos = 1;
				}
			}
			flamesText[curPos-1]=' ';
		}
		
		for(int i=0;i<6;i++){
			if (flamesText[i]!=' '){
				return flamesText[i];
			}
		}
		
		return 'x';
	}
	
	private String flamesParse(char res){
		switch(res){
		case 'f':
				return "Friendship";
		case 'l':
				return "Love";
		case 'a':
				return "Affection";
		case 'm':
				return "Marriage";
		case 'e':
				return "Enemy";
		case 's':
				return "Siblings";
		case 'n':
				return "Narcissist";
		default:
				return "Unknown";
		}
	}

}
