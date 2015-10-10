package StacksAndQueues;

import java.util.Stack;

public class Ques3_4 {

	class Tower{
		Stack<Integer> towerStk = new Stack<Integer>();
		
		public void moveDisk(int n, Tower destination, Tower buffer)throws Exception{
			if( n > 0){
				moveDisk(n-1,buffer,destination);
				moveTop(destination);
				buffer.moveDisk(n-1,destination,this);
			}
		}
		
		public void add(int item){
			towerStk.push(item);
		}
		
		public void moveTop(Tower destination) throws Exception{
			int top;
			if( !this.towerStk.empty() ){
				top = this.towerStk.pop();
				destination.towerStk.push(top);
			}else{
				throw new Exception();
			}
		}
		
		public int popItems(){
			return towerStk.pop();
		}
	}
	
	public static void main(String args[]) throws Exception{
		Ques3_4 q4 = new Ques3_4();
		Tower[] towers = new Tower[3];
		int n = 4;
		for( int i = 0; i < 3 ; i++){
			towers[i] = q4.new Tower();
		}
		for( int i = 4; i > 0 ; i--){
			towers[0].add(i);
		}
		System.out.println("processing....");

		towers[0].moveDisk(n, towers[2], towers[1]);
		
		for( int i = 0; i < n ;i++){
			System.out.println(towers[2].popItems());
		}
		
	}
}
