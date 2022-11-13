package com.maemresen.data.structures.examples;

public abstract class Matrix{


	public static int[][] add(int [][] a, int[][] b){

		int [][] result = new int[a.length][a[0].length];
		for(int i=0; i<a.length;i++){
			for(int j=0; j<a[0].length; j++){
				result[i][j] = a[i][j]+b[i][j];
			}
		}
		return result;
	}

	public static int[][] multiply(int [][] a, int[][] b){

		int [][] result = new int[a.length][a[0].length];
		for(int i=0; i<a.length;i++){
			for(int j=0; j<a[0].length; j++){
				result[i][j] = a[i][j]*b[i][j];
			}
		}
		return result;
	}

	public static void printMatrix(int[][] matrix){
		for(int [] row : matrix){
			for(int each : row){
				System.out.print(" "+each+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}