package com.maemresen.hobbyprojects.data.structures.examples;

import java.util.List;
import java.util.Random;

public class Main{


	/*
		Excercises 1-1
		Write a short Java method, inputAllBaseTypes, that inputs a different value of
		each base type from the standard input device and prints it back to the standard
		output device.
	*/

	/*
		Excercises 1-3
		Write a short Java method, isMultiple, that takes two long values, n and m, and
		returns true if and only if n is a multiple of m, that is, n = mi for some integer i.
	*/
	public static boolean isMultiple(long a, long b){
		long x = a/b;
		return a == x*b;
	}



	/*
		Excercises 1-4
		Write a short Java method, isEven, that takes an int i and returns true if and only
		if i is even. Your method cannot use the multiplication, modulus, or division
		operators, however.
	*/
	public static boolean isEven(int i){
		while(i>2){
			i -= 2;
		}
		return i == 2;
	}


	/*
		Excercises 1-5
		Write a short Java method that takes an integer n and returns the sum of all
		positive integers less than or equal to n.
	*/
	public static int sumToN(int n){

		int sum = 0;
		for(int i=1; i<=n; i++){
			sum +=n;
		}
		return sum;
	}

	/*
		Excercises 1-6
		Write a short Java method that takes an integer n and returns the sum of all the
		odd positive integers less than or equal to n.
	*/
	public static int sumOddToN(int n){
		int sum = 0;
		for(int i=1; i<=n; i+=2){
			sum += i;
		}
		return sum;
	}


	/*
		Excercises 1-7
		Write a short Java method that takes an integer n and returns the sum of the
		squares of all positive integers less than or equal to n.
	*/
	public static int sumSquaresToN(int n){
		int sum = 0;
		for(int i=1; i<=n; i++){
			sum += i*i;

		}
		return sum;
	}

	/*
		Excercises 1-8
		Write a short Java method that counts the number of vowels in a given character
		string.
	*/
	public static int numberOfVowels(String word) {

		int count = 0; // number of vowels in the given word
		for (char c : word.toCharArray()) {
			if (isVowel(c)) {
				count++; // If the current character is vowel increase count
			}
		}
		return count; // return the number of the vowels in the word
	}

	public static boolean isVowel(char c) {

		if (c < 97) {
			c += 32; // convert to the lower case
		}

		char[] vowels = { 'a', 'e', 'i', 'o', 'u'};

		for (char vowel : vowels) {
			if (vowel == c) { // return true if array contains char c
				return true;
			}
		}
		return false;
	}




	/*
		Excercises 1-9
		Write a short Java method that uses a StringBuilder instance to remove all the
		punctuation from a string s storing a sentence, for example, transforming the
		string "Let�s try, Mike!" to "Lets try Mike".
	*/
	public static String removePunctuation(String s) {

		StringBuilder sb = new StringBuilder(s);
		for(int i=0; i<sb.length(); i++){
			char c = sb.charAt(i);
			if(isPunctation(c)){
				sb.deleteCharAt(i);
			}

		}
		return sb.toString();
	}


	public static boolean isPunctation(char c){
		return c=='!' || c=='\'' || c=='.'
			|| c==','|| c=='?';
	}





	/*
		Excercises 1-14

		algorithm reverseArray is
		input Array myArray with length n

		FOR i = 0 to n/2

			Declare temp myArray[i]
			myArray[i] = temp
			myArray[i]=myArray[n-1-i]
			myArray[n-1-i] = temp

		ENDFOR


	*/
	public static void reverseArray(int [] myArray){

		for(int i=0; i<myArray.length/2; i++){
			int temp = myArray[i];
			myArray[i] = myArray[myArray.length-1-i];
			myArray[myArray.length-1-i] = temp;
		}

	}

	/*
		Excercises 1-15

		algorithm find min and max is
		input Array myArray with length n
		output Array  with length 2 for store min and max value

		Declare Array result with length 2.
		First element is minumum number
		Second element is maximum number

		result[0] = myArray[1] Assume first element as minumum number
		result[1] = myArray[1] Assume first element as maximum number

		FOR i = 0 to n

			IF myArray[i] is less than result[0]
				result[0] = myArray[i]
				continue
			ENDIF

			IF myArray[i] is greater than result[1]
				result[1] = myArray[i]
			ENDIF

		ENDFOR

		return result
	*/
	public static int[] getMinAndMax(int [] myArray){

		int [] result = new int[2];

		result[0] = myArray[0];
		result[1] = myArray[0];

		for(int i=0; i<myArray.length; i++){

			if(myArray[i] < result[0]){
				result[0] =  myArray[i];
				continue;
			}

			if(myArray[i] > result[1]){
				result[1] =  myArray[i];
			}
		}
		return result;
	}


	//Excercises 1-16
	public static boolean isValid(int a,int b, int c){
		return a+b == c || a == b-c || a*b == c;
	}

	//Excercises 1-17
	public static boolean isAllOdd(int [] array){
		for(int each : array){
			if(each % 2 == 0){
				return false;
			}
		}
		return true;
	}

	//Excercises 1-18
	public static double norm(int [] v, int p){
		int sum = 0;
		for(int each : v){
			sum += Math.pow(each,p);
		}
		return Math.pow(sum,1/((double)p));
	}

	public static double norm(int [] v){return norm(v,2);}

	//Excercises 1-19
	public static int numOfTwo(int n){
		if(n<3){
			return -1;
		}
		int count = 0;
		while(n>1){
			count++;
			n /=2;
		}
		return count;
	}


	//Excercises 1-20
	public static boolean isAllDistinct(float[] array) {

		for (int i = 0; i < array.length; i++) {
			if (isContains(i + 1, array[i], array)) {
				return false; // if it can find
			}
		}

		return true;
	}

	public static boolean isContains(int position, float value, float[] array) {

		for (int i = position; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}

		return false;
	}

	//Excercises 1-21
	public static void shuffleArray(int[] nums) {

		for (int i = nums.length - 1; i > 0; i--) {

			// Choose number from the interval [0,i]
			int select = new Random().nextInt(i + 1);

			// Change the current number with the selected number
			int temp = nums[select];
			nums[select] = nums[i];
			nums[i] = temp;

		}

	}

	//Excercises 1-21
	// Not solved
	public static void permute(int k,List<Character> subset,List<Character> charset){
		System.out.println(subset+"  "+charset);
		for(char c : charset){
			charset.remove(c);
			subset.add(0,c);
			if(k == 1){
				System.out.println(subset);
			}
			permute(k-1,subset,charset);
			charset.add(c);
		}


	}



	//Excercises 3-2
	public static void removeAll(int [] array){

		int length = array.length;
		boolean[] used = new boolean[length];

		while(length >0){
			Random rand = new Random();
			int index = rand.nextInt(length);
			int count = 0;
			for(int j=0; j<array.length; j++){
				if(used[j]){
					continue;
				}
				count++;
				if(count == index+1){
					System.out.println(array[j] +" Used");
					used[j] = true;
					length--;
					break;
				}
			}
		}

	}

	public static boolean[] removeRandom(boolean[] x){

		int count = 0;
		int currentLength = x.length;

		while(currentLength> 0){

			int k = (int)(Math.random()*currentLength);
			count = 0;
			System.out.println(k+" is k");
			for(int i=0; i<x.length; i++){

				if(!x[i]){
					continue;
				}

				count++;
				if(count == k){
					x[i] = false;
					System.out.println("x["+i+"] is made false.");
					currentLength--;
				}

			}

		}
		return x;
	}


	//Excercises 3-6
	/*

		algorithm lastSecond is
		Input: : head which is head of the list
		Output : new node which has same value with last second
		IF head.next is null then there no second node
			return null
		ENDIF

		Declare current = head to store current node and start with head
		WHILE true

			IF current.next.next = null THEN
				Declare List Node result which has same value with current
				return new List Node which has same value with current node
			ENDIF

			current = next node

		ENDWHILE


	*/

	public static int binarySearch(int [] array, int target){
		return binarySearchInterval(array,target,0,array.length-1);
	}

	public static int binarySearchInterval(int [] array, int target, int low, int high){

		if(low > high){return -1;}

		int mid = (low+high)/2;
		int midVal = array[mid];

		if(midVal == target){return mid;}

		if(midVal < target){return binarySearchInterval(array, target, midVal+1, high);}
		return binarySearchInterval(array, target, low, midVal-1);

	}

	public static int factorial(int n){return (n>1)?n* factorial(n-1):1;}


	public static void main(String[]args){

		System.out.println(factorial(5));
	}

	public static void printArray(int [] array){

		System.out.println("\nArray Start\n");
		for(int each : array){
			System.out.print(" "+each+" ");
		}
		System.out.println("\n\nArray End\n");

	}

}