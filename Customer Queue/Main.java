import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("-------- Bank System --------");	//menu	
		
		Scanner scanner = new Scanner(System.in);		
		
		LinkedQueue bank = new LinkedQueue();   //create a queue
		LinkedQueue tempQueue = new LinkedQueue();
		int[] numbers;
		int counter0=0;
		int counter1=0;
		int counter2=0;
		int counter3=0;	
		
		
		
		
		
		int choice;
		do {
			System.out.println("Current Queue: ");   //menu
			bank.display();
			System.out.println();
			System.out.println("1- Add a new customer to the queue"); 
			System.out.println("2- Process a customer");
						
			choice = scanner.nextInt();

			switch (choice) {
			case 1:				
				System.out.println("Please enter the type of customer: ");
				int customer = scanner.nextInt();
				bank.Enqueue(customer);
				Node temp = bank.peek();
				 int counter =1;
				 while(temp.getLink()!= null)   
				 {
					 Object temp_data;
					 
					 if((int)temp.getData()> (int)temp.getLink().getData())  //order the data
					 {
						 temp_data = bank.Dequeue();
						 bank.Enqueue(temp_data);
						
					 }
					 
					 temp=temp.getLink();
					 
				 }
				 
				bank.peek();
				
				System.out.println("Name of the customer: ");
				String name = scanner.nextLine();
				
			
				break;
			case 2:
				System.out.println("Customer is proccessed");
				bank.Dequeue();
				break;
			default:
			System.out.println("Wrong choice! Please choose again");
			break;
		
			}
		} while (!bank.isEmpty());	

	}

		
		
		
		
		
		
		
	}


