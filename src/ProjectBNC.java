import java.util.Random;
import java.util.Scanner;

public class ProjectBNC {

	public static void main(String[] args) {
		System.out.println("******************************************************************");
		System.out.println("*                 Welcome to bulls and cows                      *");
		System.out.println("*            Please select what would you like to do             *");
		System.out.println("*                                                                *");
		System.out.println("1 - Game Info                                                    *");
		System.out.println("2 - Play                                                         *");
		System.out.println("3 - FAQ                                                          *");
		System.out.println("4 - Exit                                                         *");
		System.out.println("*                                                                *");
		System.out.println("******************************************************************");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			gameInfo();
			break;
		case 2:
			game();
			break;
		case 3:
			FAQ();
			break;
		case 4:
			return;
		default:
			System.out.println("Please choose a correct option");
			main(null);
			break;
		}

	}

	public static void game() {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		int bulls = 0;
		int cows = 0;
		int theNumber[] = new int[4];
		int ourGuess[] = new int[4];

		int value = 9878;
		dismember(value, theNumber);
		int attempts = 0;
		int flag = 0;
		do {
			if (equalNumber(theNumber)) {

				break;

			} else {
				value = rand.nextInt(9000) + 1000;
				dismember(value, theNumber);

			}
		} while (true);
		System.out.print("Type your guess: ");
		int guess = input.nextInt();
		dismember(guess, ourGuess);
		while (guess != value) {
			if (!equalNumber(ourGuess) && guess != value || guess < 1000 || guess > 9999) {

				System.out.print("Please enter a correct number: ");
				guess = input.nextInt();
				dismember(guess, ourGuess);

			} else {
				bullsAndCows(ourGuess, theNumber);
				System.out.print("Type your guess: ");
				bulls = 0;
				cows = 0;
				guess = input.nextInt();
				dismember(guess, ourGuess);
				attempts++;

			}

		}
		System.out.println("Thats the number !!");
		System.out.println("You made a total of " + (attempts + 1) + " attempts");
		System.out.println("The number was: " + value);
	}

	public static void gameInfo() {
		System.out.println("********************************************************************");
		System.out.println("*                                                                  *");
		System.out.println("Bulls and Cows Game is also known as MasterMind.                   *");
		System.out.println("Computer selects a four digit number,all four digits are different.*");
		System.out.println("In current implementation number may not begin with 0.             *");
		System.out.println("Cows column displays total number of digits you guessed right,     *");
		System.out.println("bulls shows how many of those were placed at the right spots.      *");
		System.out.println("*                                                                  *");
		System.out.println("*           If you want to go back to the menu click 0 !           *");
		System.out.println("********************************************************************");

		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if (choice == 0) {
			main(null);
		}

	}

	public static void FAQ() {
		System.out.println("**************************************************************************************");
		System.out.println("*                                                                                    *");
		System.out.println("Question: Were any bulls or cows harmed in this game?                                *");
		System.out.println("Answer: No they are all fine !!                                                      *");
		System.out.println("Question: What will happen if i write a number bigger than 9999 or smaller than 1000?*");
		System.out.println("Answer: You will get the option to write a new number and the last one will not work.*");
		System.out.println("Question: What should i do to win the game ?                                         *");
		System.out.println("Answer: You should write the exact number that the computer chose.                   *");
		System.out.println("*                                                                                    *");
		System.out.println("*               If you want to go back to the menu click 0 !                         *");
		System.out.println("**************************************************************************************");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if (choice == 0) {
			main(null);
		}
	}

	public static void dismember(int value, int[] array) {
		array[0] = value / 1000;
		array[1] = value / 100 % 10;
		array[2] = value / 10 % 10;
		array[3] = value % 10;

	}

	public static void bullsAndCows(int array[], int array2[]) {
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (i == j) {
					if (array[i] == array2[j]) {
						bulls++;
					}
					continue;
				} else {
					if (array[i] != array2[i]) {

						if (array[i] == array2[j]) {

							cows++;
						}
					}
				}
			}
		}
		System.out.println("You got " + cows + " cows");
		System.out.println("You got " + bulls + " bulls");
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
}
