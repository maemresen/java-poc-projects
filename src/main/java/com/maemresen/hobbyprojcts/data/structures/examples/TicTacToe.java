package com.maemresen.hobbyprojcts.data.structures.examples;

public class TicTacToe{

	private int [][] table = new int[3][3];

	public void putMark(int row, int col){

		if(row > 3 || col > 3){
			System.out.println("Out of Bounds");
			return;
		}

		if(!isEmpty(row,col)){
			System.out.println("Here is full");
			return;
		}

		table[row][col]=1;

	}

	public boolean isEmpty(int row, int col){
		return table[row][col] == 0;
	}

	public int[][] getTable(){return table;}

	public static void printTable(TicTacToe ticTacToe){
		System.out.println();
		for(int [] row: ticTacToe.getTable()){
			for(int each : row){
				System.out.print(" "
				+((each == 0)?" ":((each==1)?"X":"O"))+" ");

			}
			System.out.println();
		}
		System.out.println();
	}
}