import java.util.Scanner;
public class Test{	
	private static double totalCharge = 0;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		boolean continueAdding = true;
		
		while (continueAdding == true) {
			System.out.println("please enter the hours parked\nNote: if you entered a negative value you'll quite entering values ");
			double time = in.nextDouble();
			if (time < 0)
				continueAdding = false;
			else {
				System.out.println("The charge for time parked is: " + calculatCharge(time));
				
			}
			
		}
		System.out.println("The total charge money for the day is: " + getTotal());

		

				
			

	}
	static double calculatCharge (double time) {
		double charge = 0;
		
		if (time <= 3) {
			charge = 2;
		}
		else if (time > 3) {
			if ((int) time > 3) {
			charge = 2 + ((time - 3 )* 0.5) + (  (time - (int)time)  * 0.6_666_666_667);
			}
			else 
				charge = 2  + ((time - (int)time)  * 0.6_666_666_667);
				
			if (charge >= 10)
				charge = 10;
		}
		AddTotal(charge);
		
		return charge;
	}
	static void AddTotal (double charge) {
		totalCharge += charge;
	}
	public static double getTotal () {
		return totalCharge;
	}
	
}