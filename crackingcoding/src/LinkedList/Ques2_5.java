package LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;

public class Ques2_5 {


	class LinkedList<T> implements Iterable{

		Node<T> head = null;
		Node<T> current = null;
		
		void addData( T data){
			if( head == null){
				head = new Node<T>(data);
			}else{
				Node<T> newNode = new Node<T>(data);
				Node<T> runner = head;
				
				while( runner.next != null){
					runner = runner.next;
				}
				runner.next = newNode;
			}
		}
		
		public Iterator<Node<T>> iterator(){

			current = head;
			Iterator<Node<T>> itr = new Iterator<Node<T>>(){
				public boolean hasNext(){
					return (current != null);
				}

				public Node<T> next(){
					Node<T> c = current;
					current = current.next;
					return c;
				}
			};
			
			return itr;
		}

	
	}
	
	class Node<T>{
		T data;
		Node<T> next = null;
		
		Node(T data){
			this.data = data;
		}
	}
	
	
	
	LinkedList<Integer> backAddition(LinkedList<Integer> l1, LinkedList<Integer> l2, int carry){
		if( l1.head == null && l2.head == null && carry == 0){
			return l1;
		}
		LinkedList<Integer> newL1 = new LinkedList<Integer>();
		LinkedList<Integer> newL2 = new LinkedList<Integer>();
		
		int value = carry;
		if( l1.head != null){
			value += l1.head.data;
			newL1.head = l1.head.next;
		}
		if( l2.head != null){
			value += l2.head.data;
			newL2.head = l2.head.next;
		}
		
		LinkedList<Integer> rslt = new LinkedList<Integer>();
		rslt.addData(value%10);
		
		rslt.head.next = backAddition( newL1 , newL2, value>9?1:0 ).head;
		
		return rslt;
	}
	
	class ListWrap<T>{
		LinkedList<T> sumList = new LinkedList<T>();
		int carry = 0;
	}
	
	LinkedList<Integer> forwardAddition(LinkedList<Integer> l1, LinkedList<Integer> l2){
		
		if( l1.head == null ){
			return l2;
		}else if(l2.head == null){
			return l1;
		}else if(l1.head == null && l2.head == null){
			return null;
		}
		
		int l1Len = findLength(l1);
		int l2Len = findLength(l2);
		
		if( l1Len < l2Len){
			padZero(l1,l2Len-l1Len);
		}else if( l2Len < l1Len){
			padZero(l2,l1Len-l2Len);
		}
		
		ListWrap<Integer> lWrap = new ListWrap<Integer>();
		
		addLists(l1.head,l2.head,lWrap);
		
		if( lWrap.carry != 0){
			Node<Integer> newNode = new Node<Integer>(lWrap.carry);
			newNode.next = lWrap.sumList.head;
			lWrap.sumList.head = newNode;
		}
		return lWrap.sumList;
	}
	
	void addLists(Node<Integer> n1, Node<Integer> n2, ListWrap<Integer> lWrap){
		if( n1 == null && n2 == null ){
			return;
		}
		addLists(n1.next, n2.next,lWrap);
		int value = n1.data + n2.data + lWrap.carry;
		Node<Integer> newNode = new Node<Integer>(value%10);
		newNode.next = lWrap.sumList.head;
		lWrap.sumList.head = newNode;
		lWrap.carry = value>9?1:0;
	}
	
	void padZero(LinkedList<Integer> list, int val){
		Node<Integer> newNode = null;
 		for( int i = 0; i < val; i++){
			newNode = new Node<Integer>(0);
			newNode.next = list.head;
			list.head = newNode;
		}
	}
	
	int findLength(LinkedList<Integer> list){
		if( list.head == null ){
			return 0;
		}
		Node<Integer> runner = list.head;
		int count =0;
		while( runner != null){
			runner = runner.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Enter two linked list on separate lines");
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		String[] listAry1 = br.readLine().split(" ");
		String[] listAry2 = br.readLine().split(" ");

		Ques2_5 q5 = new Ques2_5();
		LinkedList<Integer> l1 = q5.new LinkedList<Integer>();
		LinkedList<Integer> l2 = q5.new LinkedList<Integer>();
		
		for(String s : listAry1){
			l1.addData(Integer.parseInt(s));
		}
		
		for(String s : listAry2){
			l2.addData(Integer.parseInt(s));
		}
		
		System.out.println("Enter 1 to do forward addition");
		System.out.println("Enter 2 to do backward addition");
		
		int opt = Integer.parseInt(br.readLine());
		LinkedList<Integer> rslt = null;
		
		
		switch(opt){
		case 1:
			rslt = q5.forwardAddition(l1,l2);
			break;
		case 2:
			rslt = q5.backAddition(l1,l2,0);
			break;
		}

		Iterator<Node<Integer>> itr = rslt.iterator();
		
		while( itr.hasNext()){
			System.out.print(itr.next().data + " ");
		}
	}

}
