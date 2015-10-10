package StacksAndQueues;

import java.util.LinkedList;

public class Ques3_7 {

	class Animal{
		String name;
		int order;
		
		Animal(String name){
			this.name = name;
		}
		
		public void setOrder(int order){
			this.order = order;
		}
		
		private int getOrder(){
			return order;
		}
		
		public boolean isOlderThan(Animal a){
			return this.order < a.getOrder();
		}
	}
	
	class Dog extends Animal{
		Dog(String name){
			super(name);
		}
	}
	
	class Cat extends Animal{
		Cat(String name){
			super(name);
		}
	}
	
	class AnimalQueue{
		LinkedList<Dog> dog = new LinkedList<Dog>();
		LinkedList<Cat> cat = new LinkedList<Cat>();
		int order = 0;
		
		public void enque(Animal a){
			order++;
			a.setOrder(order);
			if( a instanceof Dog ){
				dog.addLast((Dog)a);
			}else{
				cat.addLast((Cat)a);
			}
		}
		
		public Animal dequeueAny(){
			Animal a;
			if( dog.isEmpty()){
				return cat.poll();
			}
			else if( cat.isEmpty()){
				return dog.poll();
			}
			
			if( dog.peek().isOlderThan(cat.peek())){
				return dog.poll(); 
			}else{
				return cat.poll();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ques3_7 q7 = new Ques3_7();
		AnimalQueue aq = q7.new AnimalQueue();
		Dog jack = q7.new Dog("jack");
		Dog browny = q7.new Dog("browny");
		Cat meeyao = q7.new Cat("meeyao");
		Dog ruby = q7.new Dog("ruby");
		
		aq.enque(jack);
		aq.enque(meeyao);
		aq.enque(browny);
		aq.enque(ruby);
		
		for( int i = 0; i < 4;i++){
			System.out.println(aq.dequeueAny().name);
		}
		
	}

}
