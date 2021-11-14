package main.java.com.randomizer;
import java.util.*;


public class RandomizerRun {
	private static final String MSG_WELCOME = "Welcome to the Randomizer!";
	private static final String MSG_QUESTION = "Do you want enter the game?\n(enter 'y' if you want to start, and another symbol, if you don't want)";
	
	private static final String RESPONSE_Y = "y";
	private static final String RESPONSE_HELP = "help";
	private static final String RESPONSE_EXIT = "exit";
	private static final String RESPONSE_GENERATE = "generate";
	
	private static final String ENTER_MAX_AND_MIN = "Set randomizer range of random numbers! ";
	private static final String ENTER_MIN = "Min: "; 
	private static final String ENTER_MAX = "Max: "; 
	
	private static final String VALIDATION = "Max and min should be positive integer and min should be >= 1, and max should be <= 500"; 
	
	
	public static void startRandomizer() {
		System.out.println(MSG_WELCOME);
		askDoYouWantEnter();
		
	}
	
	private static void askDoYouWantEnter() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(MSG_QUESTION);
		
		String enter = scanner.next();
		if (!enter.equalsIgnoreCase(RESPONSE_Y)) {
			scanner.close();
			return;
		}
		else {
			beginRandomizer();
		}
		scanner.close();
		
	}
	
	private static void beginRandomizer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(ENTER_MAX_AND_MIN);
		
		System.out.println(ENTER_MIN);
		double min = scanner.nextDouble();
		System.out.println(ENTER_MAX);
		double max = scanner.nextDouble();
		
	
		
		boolean validation = true; 
		while(validation) {
			if (min >= 1 && max<=500 && IsItPositiveNumber(min) == true && IsItPositiveNumber(max) == true ) {
				validation = false;
			}
			else {
				System.out.println(VALIDATION);
				System.out.println(ENTER_MAX_AND_MIN);
				System.out.println(ENTER_MIN);
				
				min = scanner.nextDouble();
				
				System.out.println(ENTER_MAX);
				
				max = scanner.nextDouble();
			}
		}
		
		
		int[] massiv = new int[(int)max-(int)min+1];
		int i = -1;
		boolean validation2 = true;
		while(validation2) {
			i++;
			System.out.println("Enter generate, exit or help");
			String command = scanner.next();
			if (command.equalsIgnoreCase(RESPONSE_HELP)) {
				i = i - 1;
				System.out.println("Enter exit, if you want to exit application\nEnter generate, if you want to generate random number\n");
			}
			else if(command.equalsIgnoreCase(RESPONSE_EXIT)) {
				scanner.close();
				validation2 = false;
				return;
			}
			else if(command.equalsIgnoreCase(RESPONSE_GENERATE)) {
				Random random = new Random();
				
				boolean validation3 = true;
				while(validation3) {
					if (i == massiv.length) {
						System.out.println("You went over all possible values from "+ (int)min + " to " + (int)max);
						scanner.close();
						return;
					}
					int number = random.nextInt((int)max - (int)min +1);
					number += min;
					boolean IsItReapetedNum = false;
					for (int x = 0; x<massiv.length; x++) {
						if (massiv[x]==number) {
							IsItReapetedNum = true;
						}
					}
					if (IsItReapetedNum == true) {
						number = random.nextInt((int)max - (int)min +1);
						number += min;
						for (int x = 0; x<massiv.length; x++) {
							if (massiv[x]==number) {
								IsItReapetedNum = true;
							}
						}
					}
					else {
						massiv[i] = number;
						validation3=false;
						System.out.println(number);
					}
				}
			}
			else {
				System.out.println("Error command!\n");
				i = i -1;
			}
		}
		
		
		scanner.close();
	}
	
	
	private static boolean IsItPositiveNumber(double number) {
		if (number == (int)number) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		startRandomizer();
	}
	
	
	

}
