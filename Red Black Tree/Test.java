import java.util.Scanner; 


public class Test {

	public static void main(String[] args) {
		RedBlackBST<String, Integer> rbt = new RedBlackBST<String, Integer>();
		rbt.PutVal("A", 1);
		rbt.PutVal("C", 2);
		rbt.PutVal("X", 3);
		rbt.PutVal("E", 4);
		rbt.PutVal("H", 5);
		rbt.PutVal("Mehmet", 6);
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Search: ");		
		String searchName = scan.next();
		
		System.out.println("Key: ");		
		Integer keyValue = scan.nextInt();
		
	

		/*
		 for (String s : rbt.keys())
	            System.out.println(s + " " + rbt.get(s));
	        System.out.println();
	        
	      */  
	
	}
}