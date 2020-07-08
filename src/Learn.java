import java.util.Scanner;

public class Learn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount o1 = new BankAccount("XYZ", "BA0001");
		o1.screenMenu();
		
	}

}

class BankAccount{
	
	int balance;
	int previousTrans;
	String customerName;
	String customerID;
	
	BankAccount(String custoName, String cId)
	{
		customerName = custoName;
		customerID = cId;
	}
	void deposit(int amount)
	{
		if(amount != 0) 
		{
			balance = amount + previousTrans;
			previousTrans = amount;
		}
	}
	void withdraw(int amount) 
	{
		balance = balance - amount;
		previousTrans = -amount;
	}
	void getPreviousTrans() 
	{
		if(previousTrans > 0) 
		{
			System.out.println("Deposited: "+ previousTrans);
		}
		else if(previousTrans < 0) 
		{
			System.out.println("Withdrawn: "+ Math.abs(previousTrans));
		}
		else if(previousTrans == 0)
		{
			System.out.println("No transaction occurred.");
		}
	}
	
	void screenMenu() 
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to your bank account: "+customerName);
		System.out.println("Your ID is: "+customerID);
		System.out.println("\n");
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit!");
		System.out.println("C. Make a withdraw!");
		System.out.println("D. Check your previous transaction");
		System.out.println("E. Exit");
		
		do 
		{
			System.out.println("**************************************************************************************************");
			System.out.println("Enter an option, please!");
			System.out.println("**************************************************************************************************");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			
			switch(option) 
			{
				case 'A':
					System.out.println("----------------------------------------------------------");
					System.out.println(customerName+", your current balance is: "+balance);
					System.out.println("----------------------------------------------------------");
					break;
				case 'B':
					System.out.println("----------------------------------------------------------");
					System.out.println("How much do you want to deposit?");
					System.out.println("(Enter the amount you want to pay in)");
					System.out.println("----------------------------------------------------------");
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
				case 'C':
					System.out.println("----------------------------------------------------------");
					System.out.println("How much do you want to withdraw");
					System.out.println("(Enter the amount you want to draw out)");
					System.out.println("----------------------------------------------------------");
					int amount2 = scanner.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
				case 'D':
					System.out.println("----------------------------------------------------------");
					getPreviousTrans();
					System.out.println("----------------------------------------------------------");
					break;
				case 'E':
					System.out.println("----------------------------------------------------------");
					break;
				default:
					System.out.println("Invalid Option!!. Please enter again");
					break;
			}
		}
		while(option!= 'E');
		
		System.out.println("Thank you so much for trusting us and using our services!");
	}
}

