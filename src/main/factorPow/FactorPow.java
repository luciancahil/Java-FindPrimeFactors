package main.factorPow;

public class FactorPow {
	int factor,exp,bigNum;
	
	public FactorPow(int factor, int bigNum) {
		this.factor = factor;
		this.bigNum = bigNum;
		factorize();
	}
	
	private void factorize() {
		while(bigNum%factor == 0) {
			exp++;
			bigNum /= factor;
		}
	}
	
	public int getExp() 		{return exp;}
	
	public String toString() {
		return "(" + factor + ", " + exp + ")";
	}
	
}
