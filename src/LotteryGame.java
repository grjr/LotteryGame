
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LotteryGame {
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> winList = new ArrayList<>();
	
	public ArrayList<Integer> winningNumbers() {
		Random rand = new Random();
		ArrayList<Integer> alWinning = new ArrayList<>();
		for(int i=0; i<6; i++) {
			int randomNo = rand.nextInt(49) + 1;
			if(!alWinning.contains(randomNo))
				alWinning.add(randomNo);
		}
		Collections.sort(alWinning);
		return alWinning;
	}
	
	public void matchedNumbers() {
		al.retainAll(winList);
		if(al.size()!=0) 
			System.out.println("You matched " + al.size() + " numbers - "+ al);
		else
		 System.out.println("You matched " + al.size() + " numbers");
	}
		
	public void didYouWin() {
		//Method 1 using .equals method
		if(winList.equals(al))
        	System.out.println("Congratz!! You matched all 6 numbers. You win!!");		
        else
        	System.out.println("You lose. Better luck next time!!");
		
		//Method 2 using ArrayList.containsAll method
//		if(winningNumbers().containsAll(al))
//			System.out.println("You win!!");
//		else
//        	System.out.println("You lose!!");
	}
	
	
	public static void main(String[] args) {
		
		LotteryGame lotterygame= new LotteryGame();
		winList = lotterygame.winningNumbers();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 6 numbers between 1 and 49 ");
	    	for(int i=0;i<6;i++) {
				int myNumber = sc.nextInt();
				if(!al.contains(myNumber)) {
					if(myNumber>=1 && myNumber<=49)
						al.add(myNumber);
					else {
						System.out.println("Please enter a number in the range 1-49");
						i--;
					}
				}
				else {
					System.out.println("The number is already in the list");
					i--;
				}
				
			}
	    sc.close();
    	Collections.sort(al);
		
		
        System.out.println("Your numbers are: " +al);
        
		System.out.println("The winning numbers were: " +winList);
		
        lotterygame.matchedNumbers();
        lotterygame.didYouWin();
	
	}
}

