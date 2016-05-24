package main.loveServer;

public class TrueLoveCalculator extends LoveCalculator {

	public TrueLoveCalculator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String calculate(String inputA, String inputB) {
		// TODO Auto-generated method stub
		int tens = trueLoveCounter(inputA, inputB, "true");
		int ones = trueLoveCounter(inputA, inputB, "love");
		return trueLoveParse(tens*10 + ones);
	}

	public int trueLoveCounter(String paramA, String paramB, String compStr){
		String inputA = paramA.toLowerCase();
		String inputB = paramB.toLowerCase();
		int sum = 0;
		
		for(char retval:compStr.toCharArray()){
			for(int i = 0; i<inputA.length(); i++){
				if(inputA.charAt(i)==retval){
					sum++;
				}
			}
			for(int i = 0; i<inputB.length(); i++){
				if(inputB.charAt(i)==retval){
					sum++;
				}
			}
		}
		return sum;
	}
	
	private String trueLoveParse(int trueLoveScore){
		return trueLoveScore + "% compatible";
	}
}
