/*How would you design a stack which, 
 * in addition to push and pop, also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time.*/

package Chapter_3;

import java.util.Scanner;
import java.util.Stack;

public class Question_3_2{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack_min = new Stack<>();
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("1.Push \n2.Pop \n3.Min");
			switch(scan.nextInt()){
			case 1:
					System.out.println("Enter number");
					int val  = scan.nextInt();
					if(stack.isEmpty()){
						stack_min.push(val);
					}
					else if(stack_min.peek()>=val){
						stack_min.push(val);
					}
					else{
						stack_min.push(stack_min.peek());
					}
					stack.push(val);
					break;
			case 2:
					System.out.println("Pop value is: "+ stack.pop());
					stack_min.pop();
					break;
			case 3:	System.out.println("Min is: "+ stack_min.peek());
				break;
			default: System.out.println("Wrong input");
				break;
			}
			System.out.println("Stack is: "+stack);
			System.out.println("Min Stack is "+stack_min);
			System.out.println("1. For continue");
		}while(scan.nextInt()==1);
		scan.close();
	}
}
