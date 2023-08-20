package Program2;

import java.util.ArrayList;

/*
Note:   Do not add any additional methods, attributes.  
        Do not modify the given part of the program.
        Run your program against the provided Program2Demo.java.

  		This Queue implementation will always dequeue from the first element of 
        the array i.e, elements.get(0).  
*/

public class ArrayListQueue<T> implements QueueInterface<T> {
	private ArrayList<T> elements;

	// Default constructor to initialize array capacity with CAPACITY
	public ArrayListQueue() {
		elements = new ArrayList<T>();
	}

	// Dequeue info from array. Throw QueueUnderflowException if array is empty
	public T dequeue() {

		if (elements.isEmpty())
			throw new QueueUnderflowException();
		T tempQueue = elements.get(0);
		elements.remove(0);
		return tempQueue;
	}

	// Enqueue info into array. Throw QueueOverflowException if array is full
	public void enqueue(T info) {
		elements.add(info);
	}

	// Return true if the array is empty; otherwise return false
	public boolean isEmpty() {
		if (elements.isEmpty())
			return true;
		else
			return false;
	}

	// Return true if the array is full; otherwise return false
	public boolean isFull() {
		return false;
	}

	// Return number of elements
	public int size() {
		return elements.size();
	}

	// Creates and returns a string that correctly represents the current stack.
	public String toString() {
		String items = "Size: " + size() + "\n";
		for (int i = 0; i < elements.size(); i++)
			items += elements.get(i) + "\n";
		return items;
	}
}
