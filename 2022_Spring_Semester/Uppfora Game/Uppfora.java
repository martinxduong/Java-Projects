import java.util.*;
public class Uppfora {
	static Scanner scan=new Scanner(System.in);
	static Random rand=new Random();
	public static void spacing() {
		System.out.println();
		System.out.println();
	}
	public static void rules() {
		System.out.println("To pass time during long winters, the ancient Nordic people would play the two-player game of Uppfora.");
		System.out.println("You will play against the computer, during each round, you will choose a move.");
		System.out.println("You can either choose: Skadis (s), Tjusig (t), Klyket (k), Hovolm (h), or Pershult (p).");
		System.out.println("Pershult beats Klyket & Skadis");
		System.out.println("Klyket beats Tjsig & Hovolm");
		System.out.println("Tjusig beats Pershult & Skadis");
		System.out.println("Skadis beats hovolm & Klyket");
		System.out.println("Hovolm beats Pershult & Tjusig");
		System.out.println("In event of a tie, The computer wins.");
		spacing();
	}
	
	public static String play() {
		String choice="z";
		while (!choice.equals("Y") && !choice.equals("N")) {
			System.out.print("Would you like to play around? (Enter \"Y\" for yes or \"N\" for no) ");
			choice=scan.next();
			choice=choice.toUpperCase();
		}
		if (choice.equals("Y")) {
			System.out.println("Lets Begin, Good Luck!");
			return choice;
		}else {
			System.out.println("Thanks for playing!");
			return choice;
		}
	}
	
	public static String playAgain() {
		String choice="z";
		while (!choice.equals("Y") && !choice.equals("N")) {
			System.out.print("Would you like to play another round? (Enter \"Y\" for yes or \"N\" for no) ");
			choice=scan.next();
			choice=choice.toUpperCase();
		}
		if (choice.equals("Y")) {
			System.out.println("Lets Begin, Good Luck!");
			return choice;
		}else {
			System.out.println("Thanks for playing!");
			return choice;
		}
	}
	
	public static int roundPlay() {
		int winnerRound=0; /* 1 is User wins 2 is Computer wins */
		String winner="";
		String userMove=userMove();
		String compMove=compMove();
		if (userMove.equals("P") && (compMove.equals("K") || (compMove.equals("S")))){
			winnerRound=1;
		}else if (userMove.equals("K") && (compMove.equals("Tjusig") || (compMove.equals("Hovolm")))){
			winnerRound=1;
		}else if (userMove.equals("T") && (compMove.equals("Pershult") || (compMove.equals("Skadis")))) {
			winnerRound=1;
		}else if (userMove.equals("S") && (compMove.equals("Hovolm") || (compMove.equals("Klyket")))) {
			winnerRound=1;
		}else if (userMove.equals("H") && (compMove.equals("Pershult") || (compMove.equals("Tjusig")))) {
			winnerRound=1;
		}else {
			winnerRound=2;
		}
		if (winnerRound==1) {
			winner="User";
		}else {
			winner="Computer";
		}
		String userMoveName=userMoveName(userMove);
		System.out.println("Your Move: "+userMoveName+" || Computer Move: "+compMove+" || Winner: "+winner);
		return winnerRound;
	}
	
	public static String userMoveName(String userMove) {
		String userMoveName="";
		if (userMove.equals("P")){
			userMoveName="Pershult";
		}else if (userMove.equals("K")) {
			userMoveName="Klyket";
		}else if (userMove.equals("T")) {
			userMoveName="Tjusig";
		}else if (userMove.equals("S")) {
			userMoveName="Skadis";
		}else if (userMove.equals("H")) {
			userMoveName="Hovolm";
		}
		return userMoveName;
	}
	
	public static String userMove() {
		String userMove="";
		while (!userMove.equals("S") && !userMove.equals("T") && !userMove.equals("K") && !userMove.equals("H") && !userMove.equals("P")) {
			System.out.print("Please enter a move: Skadis (s), Tjusig (t), Klyket (k), Hovolm (h), or Pershult (p) ");
			userMove=scan.next();
			userMove=userMove.toUpperCase();	
		}
		return userMove;
	}
	
	public static String compMove() {
		int compMoveNum=0; /* Move of the computer (1-5); s=1 t=2 k=3 h=4 p=5 */
		String compMove=""; /* Initials of the computer move */
		compMoveNum=rand.nextInt(5)+1;
		if (compMoveNum==1) {
			compMove="Skadis";
		}else if (compMoveNum==2) {
			compMove="Tjusig";
		}else if (compMoveNum==3) {
			compMove="Klyket";
		}else if (compMoveNum==4) {
			compMove="Hovolm";
		}else if (compMoveNum==5) {
			compMove="Pershult";
		}
		return compMove;
	}
	public static void main(String[] args) {
		int rounds=0;
		int userWon=0;
		int compWon=0;
		int winnerRound=0;
		rules();
		String choice=play();
		spacing();
		while (choice.equals("Y")) {
			winnerRound=roundPlay();
			if (winnerRound==1) {
				userWon+=1;
			}else if (winnerRound==2) {
				compWon+=1;
			}
			rounds+=1;
			choice=playAgain();
			spacing();
			spacing();
		}
		System.out.println("Rounds Played: "+rounds+" || Won User Rounds: "+userWon+" || Won Computer Rounds: "+compWon);
	}
}
