package main;

import main.factorPow.*;
import java.util.*;

public class FindPrimeFactors {
	static int bigNum; //the number that we will aim to factorize
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static ArrayList<FactorPow> factorPowers = new ArrayList<FactorPow>();
	
	
	public static void main(String[] args) {
		input();
		makePrimeList();
		factorize();
		System.out.println("The prime factorization of " + bigNum + " is " + factorPowers + "."); //outputs method
	}
	
	private static void makePrimeList() {
		boolean[] isPrime = new boolean[bigNum+2];
		
		for(int i = 2; i<isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i<((int)Math.sqrt(isPrime.length)); i++) {
			int multiplier = 2;
			if(isPrime[i]) {
				while(i*multiplier<isPrime.length) {
					int notPrime = i*multiplier;
					isPrime[notPrime] = false;
					multiplier++;
				}
			}
		}
		
		
		for(int i = 0; i<isPrime.length; i++) {
			if(isPrime[i]) {
				primes.add(i);
			}
		}
	}
	
	private static void input() {
		Scanner input = new Scanner(System.in);
		boolean entered = false;
		
		while(!entered) {
			try {
				System.out.print("Enter the number to factorize: ");
				bigNum = input.nextInt();
				entered = true;
			}catch(InputMismatchException e) {
				System.out.println("Please enter a whole number");
				input.nextLine();
			}
		}
		input.close();
	}
	
	private static void factorize() {		
		int i = 0;
		
		while(bigNum!=1) {
			if(bigNum%primes.get(i) == 0) {
				FactorPow fp = new FactorPow(primes.get(i), bigNum);
				bigNum/= Math.pow(primes.get(i), fp.getExp());
				
				factorPowers.add(fp);
			}
			i++;
		}
	}
}
