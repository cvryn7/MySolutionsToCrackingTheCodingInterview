package StacksAndQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


interface Stack{
	public void push(int stackNo,int val) throws Exception;
	public int pop(int stackNo) throws Exception;
	public boolean isEmpty(int stackNo);
	public int peek(int stackNo) throws Exception;
	public void printBuf();
}

class FixedStack implements Stack{
	
	int[] buffer = null;
	int[] pointer = {-1,-1,-1};
	int stackSize;
	
	FixedStack(int totalSize){
		totalSize = totalSize - ( totalSize%3 );
		buffer = new int[totalSize];
		stackSize = totalSize/3;
	}
	
	public void push(int stackNo, int val) throws Exception{
		if( pointer[stackNo] == stackSize-1 ){
			throw new Exception("Stack filled");
		}
		pointer[stackNo]++;
		buffer[ stackNo*stackSize + pointer[stackNo]] = val;
	}
	public int pop(int stackNo) throws Exception{
		if( pointer[stackNo] == -1 ){
			throw new Exception("Stack Empty");
		}
		int val = buffer[ stackNo*stackSize + pointer[stackNo]];
		pointer[stackNo]--;
		return val;
	}
	
	public boolean isEmpty(int stackNo){
		return pointer[stackNo] == -1;
	}
	public int peek(int stackNo) throws Exception{
		if(!isEmpty(stackNo))
		return buffer[stackNo*stackSize + pointer[stackNo]];
		throw new Exception("Nothing on top");
	}
	
	public void printBuf(){
		for( int i = 0; i < stackSize*3; i++){
			System.out.println(buffer[i]);
		}
	}
}

class InStack{
	int size;
	int pointer;
	int capacity;
	int start;
	
	InStack(int start,int cap){
		this.start = start;
		capacity = cap;
		pointer = start-1;
		size = 0;
	}
	
	public boolean isWithInStack(int idx, int totalSize){
		if( idx >= start && idx < start+capacity ){
			return true;
		}else if( start+capacity >= totalSize && idx < (start+capacity)%totalSize){
			return true;
		}
		return false;
	}
}

class FlexibleStack implements Stack{
	int[] buffer = null;
	InStack[] stack = new InStack[3];
	int maxSize;
	
	FlexibleStack(int totalSize){
		totalSize = totalSize - (totalSize%3);
		buffer = new int[totalSize];
		stack[0] = new InStack(0,totalSize/3);
		stack[1] = new InStack(totalSize/3,totalSize/3);
		stack[2] = new InStack((totalSize/3)*2,totalSize/3);
		maxSize = totalSize;
	}
	
	
	public void push(int stackNo, int val) throws Exception{
		if( stack[stackNo].size == stack[stackNo].capacity){
			//System.out.println("hello");
			if( totalElements() == maxSize ){
				throw new Exception("Total Buffer full");
			}
			shift((stackNo+1)%3);
			stack[stackNo].capacity++;
		}
		
		stack[stackNo].pointer = nextIdx(stack[stackNo].pointer);
		stack[stackNo].size++;
		buffer[stack[stackNo].pointer] = val;
	}
	
	public int pop(int stackNo) throws Exception{
		if(isEmpty(stackNo)){
			throw new Exception("Empty stack");
		}
		int val = buffer[stack[stackNo].pointer];
		stack[stackNo].pointer = previousIdx(stack[stackNo].pointer);
		stack[stackNo].size--;
		return val;
	}
	public boolean isEmpty(int stackNo){
		return stack[stackNo].size == 0;
	}
	public int peek(int stackNo) throws Exception{
		if(isEmpty(stackNo))
			throw new Exception("No element");
		return buffer[stack[stackNo].pointer];
	}
	
	private int previousIdx(int i){
		if( i == 0) return maxSize -1;
		else return i-1;
	}
	
	private int nextIdx(int i){
		if( i == maxSize-1) return 0;
		else return i+1;
	}
	
	private void shift(int stackNo){
		if( stack[stackNo].size == stack[stackNo].capacity){
			shift(stackNo%3);
			stack[stackNo].capacity++;
		}
		for( int i = (stack[stackNo].start+ stack[stackNo].capacity-1)%maxSize;
				stack[stackNo].isWithInStack(i, maxSize); i = previousIdx(i)){
			buffer[i] = buffer[previousIdx(i)];
		}
		
		buffer[stack[stackNo].start] = 0;
		stack[stackNo].start =  nextIdx(stack[stackNo].start);
		stack[stackNo].pointer = nextIdx(stack[stackNo].pointer);
		stack[stackNo].capacity--;
	}
	
	private int totalElements(){
		return stack[0].size+stack[1].size+stack[2].size;
	}
	
	public void printBuf(){
		for( int i = 0; i < maxSize; i++){
			System.out.println(buffer[i]);
		}
	}
}
public class Ques3_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter 1 for fixed size One array 3 Stacks");
		System.out.println("Enter 2 for flexible size One array 3 Stacks");
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		int opt = Integer.parseInt(br.readLine());
		
		Stack threeStack = null;
				
		switch(opt){
		case 1:
			threeStack = new FixedStack(300);
			break;
		case 2:
			threeStack = new FlexibleStack(300);
			break;
		}
		
		if( opt == 1){
			for( int i = 1; i <= 50; i++){
				threeStack.push(0, i);
				threeStack.push(1, i);
				threeStack.push(2, i);
			}
			threeStack.printBuf();
		}else if(opt == 2){
			for( int i = 1; i <= 50; i++){
				threeStack.push(0, i);
			}
			
			for( int i = 50; i <= 175; i++){
				threeStack.push(1, i);
			}
			
			for( int i = 180; i <= 290; i++){
				threeStack.push(2, i);
			}
			threeStack.printBuf();
		}
		
	}

}
