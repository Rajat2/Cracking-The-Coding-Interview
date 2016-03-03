/*Describe how you could use a single array to implement three stacks.*/
package Chapter_3;

import java.util.Arrays;
import java.util.NoSuchElementException;



public class Question_3_1 {
	int size;						//Size of array
	int array_stack[];				//Array
	int stack_pointer[];				//Number of stacks
	public Question_3_1(int size,int total_stacks) {
		// TODO Auto-generated constructor stub
		this.size = size;				
		this.stack_pointer = new int[total_stacks];
		this.array_stack = new int[size*total_stacks];
	}
	private void push(int stack_number,int val){
		int pointer = stack_number*size+stack_pointer[stack_number];
		if(isFull(stack_number)){
			System.out.println("Stack Overflow");
			System.out.println("--------------------------------------------------------------------");
			return ;
		}
		array_stack[pointer] = val;
		stack_pointer[stack_number]++;
		print();
	}
	private int pop(int stack_number){
		int pointer = stack_number*size+stack_pointer[stack_number]; 
		if(isEmpty(stack_number)){
			System.out.println("Stack Underflow");
			System.out.println("--------------------------------------------------------------------");
			return Integer.MIN_VALUE;
		}
		stack_pointer[stack_number]--;
		int val = array_stack[--pointer];
		array_stack[pointer] = 0;
		print();
		return val;
	}
	private void print(){
		System.out.println("Arrays is");
		System.out.println(Arrays.toString(array_stack));
		System.out.println("Pointer are");
		System.out.println(Arrays.toString(stack_pointer));
		System.out.println("--------------------------------------------------------------------");
	}
	
	boolean isEmpty(int index){
		return stack_pointer[index]==0;
	}
	boolean isFull(int index){
		return stack_pointer[index] >= size;
	}
	 public static void main(String[] args) throws Exception{
		 Question_3_1 q = new Question_3_1(3, 3);
		q.push(0, 10);
		q.push(0, 20);
		q.push(0, 30);
		q.push(1, 100);
		q.push(1, 200);
		q.push(1, 300);
		q.push(2, 1000);
		q.push(2, 2000);
		q.push(0, 50); 			//stack overflow
		q.pop(0);
		q.pop(0);
		q.pop(1);
		q.pop(2);
		q.pop(2);
		q.pop(2);			//Stack underflow
	 }
}
