package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Ques2_2 {

	class LinkedList implements Iterable<Node>{
		Node head = null;
		Node current = null;
		
		void addData(int data){
			if( head == null){
				head = new Node(data);
			}else{
				Node newNode = new Node(data);
				Node runner = head;
				while( runner.next != null){
					runner = runner.next;
				}
				runner.next = newNode;
			}
		}
		
		@Override
		public Iterator<Node> iterator() {
			// TODO Auto-generated method stub
			current = head;
			Iterator itr = new Iterator(){

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return (current != null);
				}

				@Override
				public Object next() {
					// TODO Auto-generated method stub
					Node c = current;
					current = current.next;
					return c;
				}
				
			};
			return itr;
		}
		
	}
	
	class Node{
		int data;
		Node next = null;
		
		Node(int data){
			this.data = data;
		}
	}
	
	class Counter{
		int cntr = 0;
	}
	
	Node findKRecursion(Node head, int k, Counter c){
		if( head == null ){
			return head;
		}else{
			Node rslt = findKRecursion(head.next,k,c);
			c.cntr += 1;
			if( c.cntr == k){
				return head;
			}
			return rslt;
		}
	}
	
	Node findKIteration(LinkedList list, int k){
		if( list.head == null || k <= 0){
			return null;
		}
		
		Node p1 = list.head;
		Node p2 = list.head;
		
		for( int i = 0; i < k-1 ; i++){
			if( p2 == null){
				return null;
			}
			p2 = p2.next;
		}
		
		while( p2.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter list to find Kth element from Last");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String[] listAry = br.readLine().split(" ");
		System.out.println("Enter K");
		int k = Integer.parseInt(br.readLine());
		
		System.out.println("Enter 1 to solve using recursion");
		System.out.println("Enter 2 to solve using iteration");
		
		int opt = Integer.parseInt(br.readLine());
		Ques2_2 q2 = new Ques2_2();
		LinkedList list = q2.new LinkedList();
		for(String s : listAry){
			list.addData(Integer.parseInt(s));
		}
		Node rslt = null;
		Counter c = q2.new Counter();
		
		switch(opt){
		case 1:
			rslt = q2.findKRecursion(list.head,k,c);
			break;
		case 2:
			rslt = q2.findKIteration(list,k);
			break;
		}
		
		System.out.println("Node data is : "+rslt.data);
	}

}
