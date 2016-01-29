import java.util.Random;
import java.util.Scanner;

public class ProjectBNC {
	public static void OTHT(int value, int[] array) {
		array[0] = value / 1000;
		array[1] = value / 100 % 10;
		array[2] = value / 10 % 10;
		array[3] = value % 10;
		// Ones, Tens , Hundreds, Thousands

	}

	public static boolean equalNumber(int array[]) {
		int flag = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					flag = 1;
					break;
				}
			}
		}
		if (flag == 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		int bulls = 0;
		int cows = 0;
		int theNumber[] = new int[4];
		int ourGuess[] = new int[4];
		int value = 9878;
		OTHT(value, theNumber);
		int attempts = 0;
		int flag = 0;
		do {
			if (equalNumber(theNumber)) {

				break;

			} else {
				value = rand.nextInt(9000) + 1000;
				OTHT(value, theNumber);

			}
		} while (true);
		System.out.print("Type your guess: ");
		int guess = input.nextInt();
		OTHT(guess, ourGuess);

		while (guess != value) {
			if (!equalNumber(ourGuess) && guess != value || guess < 1000 || guess > 9999) {

				System.out.print("Please enter a correct number: ");
				guess = input.nextInt();
				OTHT(guess, ourGuess);

			} else {
				for (int i = 0; i < ourGuess.length; i++) {
					for (int j = 0; j < theNumber.length; j++) {
						if (i == j) {
							if (ourGuess[i] == theNumber[j]) {
								bulls++;
							}
							continue;
						} else {
							if (ourGuess[i] != theNumber[i]) {

								if (ourGuess[i] == theNumber[j]) {

									cows++;
								}
							}
						}
					}
				}

				System.out.println("You got " + cows + " cows");
				System.out.println("You got " + bulls + " bulls");
				System.out.print("Type your guess: ");
				bulls = 0;
				cows = 0;
				guess = input.nextInt();
				OTHT(guess, ourGuess);
				attempts++;

			}

		}
		System.out.println("Thats the number !!");
		System.out.println("You made a total of " + (attempts + 1) + " attempts");
		System.out.println("The number was: " + value);

	}
}
