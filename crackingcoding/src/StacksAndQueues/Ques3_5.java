package StacksAndQueues;

import java.util.Stack;

public class Ques3_5 {

	class Queue<T>{
		Stack<T> oldStack = new Stack<T>();
		Stack<T> newStack = new Stack<T>();
		
		public void push(T item){
			newStack.push(item);
		}
		
		private void shiftStack(){
			if( oldStack.isEmpty() && !newStack.isEmpty() ){
				while( !newStack.isEmpty()){
					oldStack.push(newStack.pop());
				}
			}
		}
		
		public T peek(){
			shiftStack();
			if( !oldStack.isEmpty()){
				return oldStack.peek();
			}
			return null;
		}
		
		public T pop(){
			shiftStack();
			if( !oldStack.isEmpty()){
				return oldStack.pop();
			}
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques3_5 q5 = new Ques3_5();
		Queue<Integer> qInt = q5.new Queue<Integer>();
		qInt.push(3);
		qInt.push(4);
		qInt.push(5);
		System.out.println(qInt.pop());
		qInt.push(7);
		System.out.println(qInt.pop());
		System.out.println(qInt.pop());
		System.out.println(qInt.pop());
		System.out.println(qInt.pop());
		System.out.println(qInt.pop());
		System.out.println(qInt.pop());
		
	}

}
