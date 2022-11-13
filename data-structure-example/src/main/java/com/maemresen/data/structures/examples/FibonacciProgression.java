package com.maemresen.data.structures.examples;


public class FibonacciProgression extends Progression {

	private long first, second;

	public FibonacciProgression(int f, int s){
		super(f);
		first = f;
		second = s;

	}

	public void getFibonacciN(int n){
		if(n==1){
			System.out.print(" "+first);
			return;
		}

		if(n==2){
			System.out.print(" "+first+" "+second);
			return;
		}
		System.out.print(" "+first+" "+second);
		advance();

		for(int i=0; i<n-2; i++){
			System.out.print(" "+nextValue());
		}
		System.out.println();
	}

	protected void advance(){
		current = first + second;
		first = second;
		second = current;
	}



}