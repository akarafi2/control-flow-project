
public class AsciiChars {

	public static void printNumbers() {
		System.out.println("Numbers: ");
		for (char c = 48; c < 58; c++)
			System.out.print(" " + c);
		System.out.println("\n");

	}

	public static void printLowerCaseLetters() {
		System.out.println("Lower Case Letters");
		for (char c = 97; c < 123; c++)
			System.out.print(" " + c);
		System.out.println("\n");

	}

	public static void printUpperCaseLetters() {
		System.out.println("Upper Case Letters");
		for (char c = 65; c < 91; c++)
			System.out.print(" " + c);
		System.out.println("\n");

	}

}
