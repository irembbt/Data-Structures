import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AvlTree AVLtree =new AvlTree();
		AugmentedTree AVLtree2 = new AugmentedTree();
		
		
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		int [] numbers = new int[100000];
        for (int i=0; i<20000; i++) {
        	randomNumbers.add(new Integer(i));
            Collections.shuffle(randomNumbers);
        }
        
        //AVL TREE
        System.out.println("----------AVL Tree---------");
        long startTime = System.nanoTime();
        for (int i=0; i<10000; i++) {            
            numbers[i]=randomNumbers.get(i);
            //System.out.println(numbers[i]);
            AVLtree.insert(numbers[i]);
        }
        long finishTime = System.nanoTime();        
        double durationTime = finishTime-startTime;
        
        //sum time hesaplama
        
        long startSumTime = System.nanoTime();
        AVLtree.getSum(AVLtree.getRoot());
        long finishSumTime = System.nanoTime();        
        double durationSumTime = finishSumTime-startSumTime;
        
        
        //AVLtree.inOrder(AVLtree.getRoot());
        
        
        System.out.println();
        System.out.println("All items were inserted.");
        System.out.println("The time elapsed for the insertion of all items is: " + durationTime + " nanoseconds");  
        System.out.println("The result of GETSUMSMALLER for the item with value "+ numbers.length + " is " + AVLtree.getSumSmaller(AVLtree.getRoot()));
        System.out.println("The maximum value of all items is " + AVLtree.getMax(AVLtree.getRoot()));
        System.out.println("The minimum value of all items is " + AVLtree.getMin(AVLtree.getRoot()));
        System.out.println("The summation of all items is " + AVLtree.getSum(AVLtree.getRoot()));
        System.out.println("The time elapsed for GETSUM is " + durationSumTime + " nanoseconds");
        
        
        //AUGMENTED TREE
        /*
        System.out.println("----Augmented AVL Tree----");
        long startTime = System.nanoTime();
        for (int i=0; i<6; i++) {            
            numbers[i]=randomNumbers.get(i);
            //System.out.println(numbers[i]);
            AVLtree2.insert(numbers[i]);
        }
        long finishTime = System.nanoTime();        
        double durationTime = finishTime-startTime;
        
        //sum time hesaplama
        
        long startSumTime = System.nanoTime();
        AVLtree.getSum(AVLtree.getRoot());
        long finishSumTime = System.nanoTime();        
        double durationSumTime = finishSumTime-startSumTime;
        
        //AVLtree2.inOrder(AVLtree2.getRoot());
        
        
        System.out.println();
        System.out.println("All items were inserted.");
        System.out.println("The time elapsed for the insertion of all items is: " + durationTime + " nanoseconds");  
        System.out.println("The result of GETSUMSMALLER for the item with value "+ numbers.length + " is " + AVLtree2.getSumSmaller(AVLtree2.getRoot()));
        System.out.println("The maximum value of all items is " + AVLtree2.getMax(AVLtree2.getRoot()));
        System.out.println("The minimum value of all items is " + AVLtree2.getMin(AVLtree2.getRoot()));
        System.out.println("The summation of all items is " + AVLtree2.getSum(AVLtree2.getRoot()));
        System.out.println("The time elapsed for GETSUM is " + durationSumTime + " nanoseconds");*/
        
        
        
        
	}

}
