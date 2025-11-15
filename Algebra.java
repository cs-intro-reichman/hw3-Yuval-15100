// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		
		if (x2 >= 0) {
			for(int i = 0; i < x2; i++) {
			x1++; }	
		} else {
			for(int i = 0; i > x2; i--) {
				x1--; }
		}
		
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		if (x2 >= 0) {
			for(int i = 0; i < x2; i++) {
			x1--; }	
		} else {
			for(int i = 0; i > x2; i--) {
				x1++; }
		}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		
		int result = 0;

		boolean negativeResult = false;

		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0) ) {
			negativeResult = true; }

		int absX1 = x1;

		if (x1 < 0) {
			absX1 = minus(0, x1); }
		
		int absX2 = x2;

		if (x2 < 0) {
			absX2 = minus(0, x2); }

		for(int i = 0; i < absX2; i++) {
			result = plus(absX1, result);}

		if (negativeResult) {
			return minus(0, result); }

		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		
		if (n == 0) {
			return 1; }

		if (n == 1) {
			return x; }
	
	int result = x;
	int repetition = minus(n, 1);

	for (int i = 0; i < repetition; i++) {
		result = times(result, x); }

		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		if (x1 == 0) {
			return 0; }

		int result = 0;

		boolean negativeResult = false;

		if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0) ) {
			negativeResult = true; }

		int absX1 = x1;

		if (x1 < 0) {
			absX1 = minus(0, x1); }
		
		int absX2 = x2;

		if (x2 < 0) {
			absX2 = minus(0, x2); }

		while (absX1 >= absX2) {
			absX1 = minus(absX1, absX2);
			result++; }

		if (negativeResult) {
			return minus(0, result); }

		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
	
		int divisionResult = div(x1, x2);

		int multResult = times(x2, divisionResult);

		return minus(x1, multResult);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		if (x == 0) {
			return 0; }

		int squareRoot = 1;
		int result = 0;

		while (result <= x) {
			result = times(squareRoot, squareRoot);
			squareRoot++; } 

		return minus(squareRoot, 1);
	}	  	  
}