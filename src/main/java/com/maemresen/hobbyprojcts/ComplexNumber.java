package com.maemresen.hobbyprojcts;

public class ComplexNumber {
	double re;
	double im;
		
	public ComplexNumber(double a, double b){
		re = a;
		im = b;
	}
	public void wrcomplexnum(){
		System.out.println(re + "+" + im + "i");
	}
	public ComplexNumber add(ComplexNumber other){
		ComplexNumber ans;
		ans = new ComplexNumber(re+other.re , im+other.im);
		return ans;
	
	}
	public ComplexNumber multiply(ComplexNumber other){
		ComplexNumber ans;
		ans = new ComplexNumber(re*other.re-im*other.im,re*other.im+im*other.re);
		return ans;
	}
	public double getRealPart(){
		return re;
	}
	public double getImaginalPart(){
		return im;
	}


	public static void main(String[] args) {
		ComplexNumber z1, z2, z3, z4;
		double x, y;
		z1 = new ComplexNumber(5.0, 6.0);
		z2 = new ComplexNumber(6.0, 5.0);
		z1.wrcomplexnum();
		z2.wrcomplexnum();
		z3 = z1.add(z2);
		z3.wrcomplexnum();
		z4 = z1.multiply(z2);
		x = z4.getRealPart();
		y = z4.getImaginalPart();
		z4.wrcomplexnum();
		if (x == 0) {
			System.out.println(y + "i");
		} else if (y == 0) {
			System.out.println(x);
		} else {
			z4.wrcomplexnum();
		}
	}
}