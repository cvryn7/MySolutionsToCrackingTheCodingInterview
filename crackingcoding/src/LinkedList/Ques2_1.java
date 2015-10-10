package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Iterator;

public class Ques2_1 {

	class LinkedList implements Iterable<Node>{
		Node head = null;
		Node current = null;
		LinkedList(){
		}

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
			Iterator<Node> itr = new Iterator<Node>()
					{
						
						@Override
						public boolean hasNext() {
							// TODO Auto-generated method stub
							
							return (current != null);
						}

						@Override
						public Node next() {
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
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

	void solveByHashTable(LinkedList list){
		Hashtable table = new Hashtable();
		if( list.head != null ){
			Node runner = list.head;
			Node prev = null;
			while( runner != null){
				if( table.containsKey(runner.data)){
					prev.next = runner.next;
				}else{
					table.put(runner.data, true);
					prev = runner;
				}
				runner = runner.next;
			}
		}
	}

	void solveInPlace(LinkedList list){
		if( list.head != null ){
			Node current = list.head;
			
			while( current != null){
				Node runner = current;
				while( runner.next != null){
					if( runner.next.data == current.data){
						runner.next = runner.next.next;
					}
					runner = runner.next;
				}
				current = current.next;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the list with duplicates");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

		String[] dataAry = br.readLine().split(" ");

		System.out.println("Enter 1 to solve using Hashtable");
		System.out.println("Enter 2 to solve in place");

		int opt = Integer.parseInt(br.readLine());

		Ques2_1 q1 = new Ques2_1();
		LinkedList list = q1.new LinkedList();
		for(String s : dataAry){
			list.addData(Integer.parseInt(s));
		}

		switch(opt){
		case 1:
			q1.solveByHashTable(list);
			break;
		case 2:
			q1.solveInPlace(list);
			break;
		}
		
		Iterator<Node> itr = list.iterator();
		
		while( itr.hasNext()){
			System.out.print( itr.next().data + " " );
		}
		

	}

}
