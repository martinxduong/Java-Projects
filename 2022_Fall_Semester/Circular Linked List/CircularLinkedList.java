package circularlinkedlist;
import java.util.Iterator;
import java.util.Scanner;

public class CircularLinkedList<E> implements Iterable<E> {

	
	
	// Your variables
	Node<E> head;
	Node<E> tail;
	int size;  // BE SURE TO KEEP TRACK OF THE SIZE

	
	// implement this constructor
	
	public CircularLinkedList() {
	}


	// I highly recommend using this helper method
	// Return Node<E> found at the specified index
	// be sure to handle out of bounds cases
	private Node<E> getNode(int index ) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index out of Bounds.");
		}
		Node<E> current = head;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}


	// attach a node to the end of the list
	public boolean add(E item) {
		/*
		Node<E> newNode = null;
		this.add(size,item);
		if(size == 0){
			head = newNode;
		}
		*/
		this.add(size,item);
		return true;
	}

	
	// Cases to handle
	// out of bounds
	// adding to empty list
	// adding to front
	// adding to "end"
	// adding anywhere else
	// REMEMBER TO INCREMENT THE SIZE
	public void add(int index, E item){
		if(index < 0 || index > size){ // Out of Bounds
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node<E> adding = new Node(item);
		if(size == 0){ // Empty List
			this.head = adding;
			this.tail = adding;
		} else if(index == 0){ // Front List
			adding.next = head;
			head = adding;
			tail.next = head;
		} else if(index == size){ // End List
			tail.next = adding;
			tail = adding;
			adding.next = head;
		} else{ // Anywhere 
			Node<E> before = getNode(index - 1);
			adding.next = before.next;
			before.next = adding.next;
		}
		size++;
	}

	

	
	
	// remove must handle the following cases
	// out of bounds
	// removing the only thing in the list
	// removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
	// removing the last thing 
	// removing any other node
	// REMEMBER TO DECREMENT THE SIZE
	public E remove(int index) { // Out of Bounds
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		E toReturn = null;
		if(size == 1){ //Only Thing in the List
			toReturn = head.item;
			head = null;
			tail = null;
		} else if(index == 0){ //First Thing
			toReturn = head.item;
			head = head.next;
			tail.next = head;
		} else if(index == size - 1){ //Last Thing
			Node<E> before = getNode(index - 1);
			toReturn = tail.item;
			tail = before;
			tail.next = head;  
		} else{ //Anywhere
			Node<E> before = getNode(index - 1);
			toReturn = before.next.item;
			before.next = before.next.next;
		}
		
		size--;
		return toReturn;
	}
	
	
	
	
	// Turns your list into a string
	// Useful for debugging
	public String toString(){
		Node<E> current =  head;
		StringBuilder result = new StringBuilder();
		if(size == 0){
			return "";
		}
		if(size == 1) {
			return head.item.toString();
			
		}
		else{
			do{
				result.append(current.item);
				result.append(" ==> ");
				current = current.next;
			} while(current != head);
		}
		return result.toString();
	}
	
	
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}
	
	// provided code for different assignment
	// you should not have to change this
	// change at your own risk!
	// this class is not static because it needs the class it's inside of to survive!
	private class ListIterator<E> implements Iterator<E>{
		
		Node<E> nextItem;
		Node<E> prev;
		int index;
		
		@SuppressWarnings("unchecked")
		//Creates a new iterator that starts at the head of the list
		public ListIterator(){
			nextItem = (Node<E>) head;
			index = 0;
		}

		// returns true if there is a next node
		// this is always should return true if the list has something in it
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size != 0;
		}
		
		// advances the iterator to the next item
		// handles wrapping around back to the head automatically for you
		public E next() {
			// TODO Auto-generated method stub
			prev =  nextItem;
			nextItem = nextItem.next;
			index =  (index + 1) % size;
			return prev.item;
	
		}
		
		// removed the last node was visted by the .next() call 
		// for example if we had just created a iterator
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		public void remove() {
			int target;
			if(nextItem == head) {
				target = size - 1;
			} else{ 
				target = index - 1;
				index--;
			}
			CircularLinkedList.this.remove(target); //calls the above class
		}
		
	}
	
	// It's easiest if you keep it a singly linked list
	// SO DON'T CHANGE IT UNLESS YOU WANT TO MAKE IT HARDER
	private static class Node<E>{
		E item;
		Node<E> next;
		
		public Node(E item) {
			this.item = item;
		}
		
	}
	
	public static void main(String[] args){
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of people: ");
		int n = scan.nextInt();
		System.out.println("Enter the number of counts: ");
		int k = scan.nextInt();
		scan.close();
		System.out.println();
		System.out.println();
		for(int i = 1; i < n+1; i++){
			list.add(i);
		}
		Iterator<Integer> iterate = list.iterator();
		System.out.println(list);
		while(iterate.hasNext() == true){
			for(int i = 0; i < k; i++){
				iterate.next();
			}
			iterate.remove();
			System.out.println(list);
		}
		
		
		
		
		
		
	}



	
	
}
