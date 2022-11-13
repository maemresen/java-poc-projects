package com.maemresen.data.structures.examples;

public class Test {
	public static void main (String[] args) {

		boolean barray[] = new boolean[20];
		for(int i=0; i<20; i++) {
			barray[i] = true;
		}

		boolean[] bs;
		bs = removeRandomFromArrayUntilEmpty(barray);
		for(int i=0; i<barray.length; i++) {
			System.out.print(barray[i] + " ");
		}


	}

	public static boolean[] removeRandomFromArrayUntilEmpty(boolean[] x) {
		int count = 0;
		int currentLength = x.length;
		int c1=0, c2=0;
		while(currentLength>0) {
			count=0;
			c1++;



			int k = (int)(Math.random()*currentLength);
			for(int i=0; i<x.length; i++) {
				c2++;


//				System.out.println("k: " + k);
				if(!x[i])
					continue;

			if(count==k) {
				x[i] = false;
				System.out.println("x[" + i + "] is made false.");
				currentLength--;
			}
			if(x[i]) {
				System.out.println("count: " + count);
				count++;
			}
		}
	}
		System.out.println("steps: " + c1*c2+" "+c1+" "+c2);
		return x;

	}





	public static boolean checkIfAllFalse (boolean[] b) {

		for (int i=0; i<b.length; i++) {
			if(b[i]==true)
				return false;
		}
		return true;
	}


}