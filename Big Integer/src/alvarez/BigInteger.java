package alvarez;

public class BigInteger {
	
	private String x;
	
	public BigInteger(String x) {
		//throws exception if input doesn't contain only digits
		if (!x.matches("\\d+")) {
			throw new IllegalArgumentException("Input must" +
					" contain only digits.");
		}
		this.x = x;
	}
	
	
	public BigInteger add(BigInteger x) {
		
		//convert the inputs into strings
		String a = new StringBuilder(this.toString()).reverse().toString();
		String b = new StringBuilder(x.toString()).reverse().toString();
		
		//ensure that b is the longer string
		if (a.length() > b.length()) {
			String t = a;
			a = b;
			b = t;
		}
		
		//variables for length of the strings
		int n1 = a.length();
		int n2 = b.length();
		
		//to carry when adding
		int carry = 0;
		
		//string to store result
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < n1; i++) {
			
			//start adding both numbers together
			int sum = ((a.charAt(i) - '0') + (b.charAt(i) - '0') + carry);
			str.append((char)(sum % 10 + '0'));
			carry = sum / 10;
			
		}
		
		//add on any remaining digits from longer number
		for (int i = n1; i < n2; i++) {
			int sum = ((b.charAt(i) - '0') + carry);
			str.append((char)(sum % 10 + '0'));
			carry = sum / 10;
		}
		
		//ensure the carry value is distributed
		if (carry > 0) str.append((char)(carry + '0'));
		
		return new BigInteger(str.reverse().toString());
	}
	
	//converts big integer to a string
	@Override
	public String toString() {
		return this.x;
	}
	
	//returns the remainder of integer division
	public BigInteger mod(BigInteger divisor) {
		BigInteger remainder = this.divideAndRemainder(divisor)[1];
		
		if (new java.math.BigInteger(remainder.toString()).compareTo(new java.math.BigInteger("0")) < 0) {
			remainder = remainder.add(divisor);
		}
		
		return remainder;
	}
	
	//division to get remainder
	public BigInteger[] divideAndRemainder(BigInteger divisor) {
		BigInteger quotient = new BigInteger("0");
        BigInteger remainder = new BigInteger(this.x);
        
        //while remainder is greater than or equal to the divisor
        while (new java.math.BigInteger(remainder.toString()).compareTo(new java.math.BigInteger(divisor.toString())) >= 0) {
            remainder = remainder.subtract(divisor);
            quotient = quotient.add(new BigInteger("1"));
        }

        return new BigInteger[] { quotient, remainder };
	}
	
	//subtraction to support division
	public BigInteger subtract(BigInteger other) {
        String a = this.x;
        String b = other.x;

        //ensure A is larger or equal to B
        if (a.length() < b.length() || (a.length() == b.length() && a.compareTo(b) < 0)) {
            throw new IllegalArgumentException("Subtraction results in negative value.");
        }

        StringBuilder result = new StringBuilder();

        //reverse both strings for easier handling of digits
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int n1 = a.length();
        int n2 = b.length();

        int borrow = 0;

        //subtract digits of both numbers
        for (int i = 0; i < n2; i++) {
            int sub = (a.charAt(i) - '0') - (b.charAt(i) - '0') - borrow;

            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append((char)(sub + '0'));
        }

        //remaining digits of the longer number
        for (int i = n2; i < n1; i++) {
            int sub = (a.charAt(i) - '0') - borrow;

            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append((char)(sub + '0'));
        }

        //remove leading zeros from the result
        String res = result.reverse().toString().replaceFirst("^0+(?!$)", "");

        return new BigInteger(res);
    }	

}
