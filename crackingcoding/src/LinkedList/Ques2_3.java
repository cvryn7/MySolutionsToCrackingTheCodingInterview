package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Ques2_3 {

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
			
			Iterator<Node> itr = new Iterator<Node>(){

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
	}
	
	void deleteKth(Node runner){
		Node next = runner.next;
		runner.data = next.data;
		runner.next = next.next;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the list in which middle element needs to be deleted");
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		String[] listAry = br.readLine().split(" ");
		System.out.println("Enter the index of element to delete");
		int k = Integer.parseInt(br.readLine());
		Ques2_3 q3 = new Ques2_3();
		LinkedList list = q3.new LinkedList();
		
		for( String s : listAry){
			list.addData(Integer.parseInt(s));
		}
		
		Node runner = null;
		int counter = 0;
		if( list.head != null){
			runner = list.head;
			counter = 0;
		}else{
			return;
		}
		
		while( runner.next != null ){
			runner = runner.next;
			counter++;
			if( counter == k-1){
				break;
			}
		}
		if( runner.next == null){
			System.out.println("NOT POSSIBLE");
			return;
		}
		q3.deleteKth(runner);
		
		Iterator<Node> itr = list.iterator();
		
		while( itr.hasNext() ){
			System.out.print(itr.next().data + " ");
		}
	}

}
