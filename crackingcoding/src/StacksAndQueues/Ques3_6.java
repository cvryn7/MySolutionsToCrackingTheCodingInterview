package StacksAndQueues;

import java.util.Random;
import java.util.Stack;

public class Ques3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> unSortedStk = new Stack<Integer>();
		Stack<Integer> sortedStk = null;
		Random rnd = new Random();
		
		for(int i = 0; i < 100 ; i++){
			unSortedStk.push(rnd.nextInt(100)+1);
		}
		
		sortedStk = sort(unSortedStk);
		
		while( !sortedStk.isEmpty()){
			System.out.println(sortedStk.pop());
		}
		
	}
	
	public static Stack<Integer> sort(Stack<Integer> unSorted){
		Stack<Integer> sorted = new Stack<Integer>();
		int temp;
		while(!unSorted.isEmpty()){
			temp = unSorted.pop();
			while( !sorted.isEmpty() && sorted.peek() > temp){
				unSorted.push(sorted.pop());
			}
			sorted.push(temp);
		}
		
		return sorted;
	}

}
