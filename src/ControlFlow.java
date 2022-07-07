import java.util.*;
import java.util.regex.Pattern;

public class ControlFlow {

	public static void main(String[] args) {

		AsciiChars.printNumbers();
		AsciiChars.printUpperCaseLetters();
		AsciiChars.printLowerCaseLetters();

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Please enter your name: ");
			String userName = scanner.nextLine();
			if (!Pattern.matches("[a-zA-Z]+", userName)) {
				System.out.print("Please enter the name using letters only: ");
				continue;
			}
			System.out.print(
					"Hello " + userName + ", Would you like to continue to the interactive portion? (yes / y): ");
			break;
		} while (true);
		boolean cont = true;
		do {
			String choice = scanner.nextLine();

			switch (choice) {
			case "yes", "y":
				System.out.print("Thank you for continuing to the interactive portion.\n");
				cont = false;
				break;
			case "no", "n":
				System.out.print("Please return later to complete the survey.");
				scanner.close();
				return;
			default:
				System.out.println("Please enter \"yes\" or \"no\"");
				System.out.print("Would you like to continue to the interactive portion? (yes / y): ");
				break;
			}
		} while (cont);

		String generateAnotherSet;
		do {
			String question0 = "Do you  have a red car? (yes/no) : ";
			String question1 = "What's the name of your favorite pet? : ";
			String question2 = "What's the age of your favorite pet? : ";
			String question3 = "What is your Lucky Number? : ";
			String question4 = "Do you have a favorite quarterback? (yes/no): ";
			String question5 = "What is their jersey number? : ";
			String question6 = "What is the two-digit model year of your car? : ";
			String question7 = "What is the first name of your favorite actor or actress? : ";
			String question8 = "Enter a random number between 1 and 50. : ";

			// Creating an Array of questions

			Question[] questions = { new Question(question0, "0"), new Question(question1, "0"),
					new Question(question2, "0"), new Question(question3, "0"), new Question(question4, "0"),
					new Question(question5, "0"), new Question(question6, "0"), new Question(question7, "0"),
					new Question(question8, "0") };

// Generating three random numbers

			Random random = new Random();
			int random1 = random.nextInt(66);
			System.out.println("\nRandom number 1 = " + random1);

			int random2 = random.nextInt(66);
			System.out.println("\nRandom number 2 = " + random2);

			int random3 = random.nextInt(66);
			System.out.println("\nRandom number 3 = " + random3 + "\n");

			startSurvey(questions);

			System.out.println("\n Generating Lottery Numbers: \n");
			System.out.println("###############################################################");
			System.out.println("##                                                           ##");
			
			int jerseyNumber = Integer.parseInt(questions[5].userAnswer);
			int luckyNumber = Integer.parseInt(questions[3].userAnswer);
			if (jerseyNumber > 0)
				luckyNumber = jerseyNumber;
			int magicBallNumber = magicBall(luckyNumber, random1);

// Use the two digit model year of their car and add their lucky number to it.
			int modelYear = Integer.parseInt(questions[6].userAnswer);
			int luckyN = Integer.parseInt(questions[3].userAnswer);
			int number1 = lotteryNumber1(modelYear, luckyN);

// Use the random number between 1 and 50, subtracting one of the generated random numbers.
			int randomN = Integer.parseInt(questions[8].userAnswer);

			int number2 = lotteryNumber2(randomN, random2);

// Convert the first letter of their favorite actor/actress to an integer and use that value.
			String favActor = questions[7].userAnswer;
			char firstLetter = favActor.charAt(0);
			int flValue = firstLetter;
			int number3 = lotteryNumberInRange(flValue);

//Convert the last letter of their favorite actor/actress to an integer and use that value.

			char lastLetter = favActor.charAt(favActor.length() - 1);
			int llValue = lastLetter;
			int number4 = lotteryNumberInRange(llValue);

// Use the value 42.
			int number5 = 42;

			System.out.print("##     Lottery numbers: " + number1 + ", " + number2 + ", " + number3 + ", " + number4 + ", "
					+ number5);
			System.out.println(" Magic Ball: " + magicBallNumber + "     ##");
			System.out.println("##                                                           ##");
			System.out.println("###############################################################");
			System.out.print("\n Would you like to answer questions to generate another set of numbers? (yes/no): ");
			generateAnotherSet = scanner.nextLine();
			if (generateAnotherSet.equals("y"))
				generateAnotherSet = "yes";
		} while (generateAnotherSet.equals("yes"));

		System.out.println("\n############ Thank you for playing ############");
		scanner.close();
		return;

	}

	public static int lotteryNumber1(int model, int lucky) {
		int number1 = model + lucky;

		while (number1 > 66) {
			number1 -= 65;
		}
		;

		return number1;
	}

	public static int lotteryNumber2(int random1, int random2) {
		int number2 = random1 - random2;

		while (number2 < 0) {
			number2 += 65;
		}

		while (number2 > 65) {
			number2 -= 65;
		}

		return number2;

	}

	public static int lotteryNumberInRange(int value) {

		while (value > 65) {
			value -= 65;
		}

		return value;

	}

	public static int magicBall(int number, int random) {

		int mBallMax = 75;
		int magicBall = number * random;

		while (magicBall > mBallMax) {

			magicBall -= mBallMax;

		}
		return magicBall;

	}

	public static void startSurvey(Question[] questions) {

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < questions.length; i++) {

			System.out.print(questions[i].askUser);
			questions[i].userAnswer = scanner.nextLine();
			switch (i) {

			case 0, 4:

				if (!(questions[i].userAnswer.equals("yes")) && !(questions[i].userAnswer.equals("no"))) {

					System.out.println(" Please enter yes or no ");
					i -= 1;
				}
				break;

			case 1, 7:

				if (!Pattern.matches("[a-zA-Z]+", questions[i].userAnswer)) {
					System.out.println("Please enter the name using letters only: \n");
					i -= 1;
				}
				break;
			case 2, 3, 5:
				if (!Pattern.matches("[0-9]+", questions[i].userAnswer)) {
					System.out.println("Please enter a valid integer value: \n");
					i -= 1;
				}
				break;
			case 6:
				if (!Pattern.matches("\\d{2}", questions[i].userAnswer)) {
					System.out.println("Please enter two digits number only: \n");
					i -= 1;
				} 
					
				break;
			case 8:
				boolean inRange = Pattern.matches("[1-9]|[1-4][0-9]|[5][0]", questions[i].userAnswer);
				if (!inRange) {
					System.out.println("Please enter a number between 1 and 50 only: \n");
					i -= 1;
			
				} 
				break;
				
			default:
				break;
			}

			if (i == 4 && questions[i].userAnswer.equals("no"))
				i++;
		}
		
	}
	

}
