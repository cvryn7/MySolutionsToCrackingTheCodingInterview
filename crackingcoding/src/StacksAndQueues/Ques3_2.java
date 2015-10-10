package StacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ques3_2 {

	interface MyStack{
		public void spush(int data);
		public int spop();
		public int speek();
		public boolean isSEmpty();
		public int peekMin() throws Exception;
		
	}
	
	class MinStack1 extends Stack<MinNode> implements MyStack {
		public void spush(int data){
				int min = Math.min(data, min());
				MinNode node = new MinNode(data,min);
				super.push(node);
		}
		
		public int spop(){
			return super.pop().value;
		}
		
		public int speek(){
			return super.peek().value;
		}
		
		public boolean isSEmpty(){
			return super.isEmpty();
		}
		public int min(){
			if( super.isEmpty()){
				return Integer.MAX_VALUE;
			}
			
			return super.peek().min;
		}
		
		public int peekMin() throws Exception{
			if( super.isEmpty()){
				throw new Exception();
			}
			return super.peek().min;
		}
	}
	
	class MinNode{
		int value;
		int min;
		MinNode(int value, int min){
			this.value = value;
			this.min = min;
		}
	}
	
	class MinStack2 extends Stack<Integer> implements MyStack{
		Stack<Integer> s1 = null;
		MinStack2(){
			s1 = new Stack<Integer>();
		}
		
		public void spush(int data){
			if( data <= min()){
				s1.push(data);
			}
			super.push(data);
		}
		
		public int spop(){
			if( super.peek() == s1.peek()){
				s1.pop();
			}
			return super.pop();
		}
		
		public boolean isSEmpty(){
			return super.isEmpty();
		}
		
		public int speek(){
			return super.peek();
		}
		
		public int min(){
			if( s1.isEmpty()) return Integer.MAX_VALUE;
			return s1.peek();
		}
		
		public int peekMin() throws Exception{
			if( super.isEmpty()){
				throw new Exception();
			}
			return s1.peek();
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter 1 to make min stack using nodes");
		System.out.println("Enter 2 to make min stack using extra stack");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opt = Integer.parseInt(br.readLine());
		Ques3_2 q3 = new Ques3_2();
		MyStack stack = null;
		switch(opt){
		case 1:
			stack = q3.new MinStack1();
			break;
		case 2:
			stack = q3.new MinStack2();
			break;
		}
		
		stack.spush(5);
		stack.spush(4);
		stack.spush(3);
		stack.spush(2);
		stack.spush(1);
		stack.spush(0);
		
		while(!stack.isSEmpty()){
			System.out.println("data: "+stack.speek()+" Min: "+stack.peekMin());
			stack.spop();
		}
	}

}
