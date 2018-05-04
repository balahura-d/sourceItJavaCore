package lesson08.homework8;

public class ConvertNumbersFromArabicToRomanAndViceVersa {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(String.format("%d ====> %s ====> %d", 
							 i, 
							 decimalToRoman(i), 
							 romanToDecimal(decimalToRoman(i))));
		}
	}

	private static int romanToDecimal(String decimalToRoman) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static String decimalToRoman(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
