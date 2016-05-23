package main.loveServer;

public class FlamesCalculator extends LoveCalculator {

	@Override
	public String calculate(String inputA, String inputB) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int flamesCount(String paramA, String paramB){
		String inputA = paramA.toLowerCase();
		String inputB = paramB.toLowerCase();
		
		for(Character retChar:inputA.toCharArray()){
			System.out.println(inputB.indexOf(retChar));
			if(inputB.indexOf(retChar)>-1){
				inputA = inputA.replace(retChar.toString(), "");
				inputB = inputB.replace(retChar.toString(), "");
				System.out.println(retChar.toString());
				System.out.println(inputB);
			}
		}
		return inputA.length() + inputB.length();
	}

}
