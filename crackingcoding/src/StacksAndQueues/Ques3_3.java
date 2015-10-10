package StacksAndQueues;

import java.util.ArrayList;

public class Ques3_3 {

	class StackOfStacks{
		ArrayList<stack> stacks = new ArrayList<stack>();
		int capacityOfEachStack;
		StackOfStacks(int capacity){
			this.capacityOfEachStack = capacity;
		}

		public void push(int data) throws Exception{
			stack last = getLastStack();
			if( last == null || !last.hasCapacity() ){
				stack s = new stack(capacityOfEachStack);
				s.push(data);
				stacks.add(s);
			}else{
				last.push(data);
			}
		}

		public int pop() throws Exception{
			int data;
			stack last = getLastStack();
			if( last.size == 1 ){
				stacks.remove(stacks.size()-1);
			}
			data = last.pop();
			return data;
		}

		public int popAt(int idx) throws Exception{
			int data = -1;
			if( idx < stacks.size()-1 ){
				stack popStack = stacks.get(idx);
				if( popStack.size > 0)
					data = popStack.pop();
				shiftStacks(idx);
			}else if( idx == stacks.size()-1){
				data = getLastStack().pop();
			}
			return data;
		}

		public void shiftStacks(int idx) throws Exception{
			int currentIdx = idx+1;
			stack currentStack = null;
			int data;
			if( currentIdx == stacks.size()){
				return;
			}
			currentStack = stacks.get(currentIdx);
			data = currentStack.bottom.data;
			stacks.get(currentIdx-1).push(data);
			currentStack.bottom = currentStack.bottom.above;
			currentStack.bottom.below = null;
			currentStack.size--;
			if( currentStack.isEmpty()){
				stacks.remove(currentIdx);
			}
			shiftStacks(currentIdx);
		}

		public int peek(){
			return getLastStack().peek();
		}

		public stack getLastStack(){
			if( stacks.size() > 0 )
				return stacks.get(stacks.size()-1);
			return null;
		}

		public void print(){
			for(int i = 0; i < stacks.size();i++){
				stacks.get(i).print();
			}
		}

	}

	class stack{
		Node bottom, top;
		int capacity;
		int size;

		stack(int capacity){
			this.capacity = capacity;
			size = 0;
		}

		public void push(int data) throws Exception{
			if( !hasCapacity() ){
				throw new Exception();
			}
			Node newNode = new Node(data);
			if(size == 0){
				bottom = newNode;
				top = newNode;
			}else{
				newNode.below = top;
				top.above = newNode;
				top = newNode;
			}
			size++;
		}

		public int pop() throws Exception{
			if( size == 0){
				throw new Exception();
			}
			Node x = top;
			if( size == 1){
				bottom = null;
				top = null;
				return x.data;
			}
			top = top.below;
			top.above = null;
			size--;
			return x.data;
		}

		public int peek(){
			return top.data;
		}

		public boolean isEmpty(){
			return size==0;
		}

		public boolean hasCapacity(){
			return capacity > size;
		}

		public void print(){
			Node prnt = bottom;
			for(int i=0; i< size; i++){
				System.out.print(prnt.data+" ");
				prnt = prnt.above;
			}
			System.out.println();
		}
	}


	class Node{
		Node above = null;
		Node below = null;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	// TODO Auto-generated method stub

	public static void main(String args[]) throws Exception{
		Ques3_3 q3 = new Ques3_3();
		StackOfStacks sos = q3.new StackOfStacks(3);
		for( int i = 1; i <= 30; i++){
			sos.push(i);
		}
		sos.print();
		sos.pop();
		sos.print();
		sos.pop();
		sos.print();
		sos.pop();
		sos.pop();
		sos.print();
		sos.popAt(2);
		sos.print();
	}
}


