package com.fanjavaid.algorithms.groking_algorithms;

public class RecursionFactorial {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	public static int factorial(int n) {
		// Base case
		int returnValue = 0;

		if (n == 1) {
			return returnValue = 1;
		}

		returnValue = n * factorial(n-1);

		System.out.println("factorial("+n+") return "+returnValue);

		return returnValue;
	}
}
