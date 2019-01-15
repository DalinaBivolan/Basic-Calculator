package tac.application.util;

public class Sum {
	
	private Double a;
	private Double b;
	
	public Sum(Double a, Double b){
		this.a = a;
		this.b = b;
	}

	public Double sum(){
		Double result = a + b;
		
		return result;
	}
}
