package main.loveServer;

public class FlamesCalculator extends LoveCalculator {

	@Override
	public String calculate(String inputA, String inputB) {
		// TODO Auto-generated method stub
		int flamesCount = removeSimilarLetters(inputA, inputB);
		String result = flamesResultString(flamesResultChar(flamesCount));
		return result;
	}
	
	private int removeSimilarLetters(String paramA, String paramB){
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
	
	private char flamesResultChar(int flamesCount){
		StringBuilder flamesText = new StringBuilder("flames");
		int curPos=1;
		
		if(flamesCount == 0){
			return 'n';
		}
		for (int i = 0; i<5; i++){
			int j = 1;
			for(j=1;j<flamesCount;j++){
				curPos++;
				if(curPos > flamesText.length()){
					curPos = 1;
				}
			}
			flamesText.deleteCharAt(curPos-1);
			if(curPos > flamesText.length()){
				curPos = 1;
			}
		}
		
		return flamesText.charAt(curPos-1);
	}
	
	private String flamesResultString(char res){
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
