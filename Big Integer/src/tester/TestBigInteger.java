package tester;
import alvarez.BigInteger;

public class TestBigInteger {

	public static void main(String[] args) {
		
		
		//TEST 1: INITIALIZE AND PRINT A BIG INTEGER
		BigInteger a = new BigInteger("1234567898765");
		System.out.println("\nTEST 1: INITIALIZE A BIG INTEGER -> " + a.toString());
		
		
		//TEST 2: ADDING TWO BIG INTEGERS
		a = new BigInteger("102429729347529");
		BigInteger b = new BigInteger("94757128374838292745");
		System.out.println("\nTEST 2: ADDING A+B");
		System.out.println("\tA: " + a.toString());
		System.out.println("\tB: " + b.toString());
		System.out.println("\tRESULT -> " + a.add(b));
		
		//TEST 3: B % A
		System.out.println("\nTEST 3: B % A -> " + b.mod(a));
		
		//TEST 4: A % B
		System.out.println("\nTEST 4: A % B -> " + a.mod(b));
		
		//TEST 5: INITIALIZE A BIG INTEGER CONTAINING LETTERS
		System.out.println("\nTEST 5: INITIALIZE A BIG INTEGER CONTAINING LETTERS: ");				
		BigInteger x = new BigInteger("12345678987h65");
		
	}

}
