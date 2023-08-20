package Program2;

/*
Note:   Do not add any additional methods, attributes.  
        Do not modify the given part of the program.
        Run your program against the provided Program2Demo.java.

  		This Queue implementation will always dequeue from the first element of 
        the array i.e, elements[0].  Therefore, remember to shift all elements 
        toward front of the queue after each dequeue.
*/

public class FixedFrontArrayQueue<T> implements QueueInterface<T> {
	private static int CAPACITY = 100;
	private T[] elements;
	private int rearIndex;

	// Default constructor to initialize array capacity with CAPACITY
	public FixedFrontArrayQueue() {
		elements = (T[]) new Object[CAPACITY];
	}

	// Constructor to initialize array capacity with 'size'
	public FixedFrontArrayQueue(int size) {
		elements = (T[]) new Object[size];
	}

	// Dequeue info from array. Throw QueueUnderflowException if array is empty
	public T dequeue() {
		T tempQueue = elements[0];
		for (int i = 0; i < rearIndex - 1; i++) {
			elements[i] = elements[i + 1];
		}
		if (rearIndex < elements.length - 1)
			throw new QueueUnderflowException();
		rearIndex--;
		return tempQueue;
	}

	// Enqueue info into array. Throw QueueOverflowException if array is full
	public void enqueue(T info) {
		if (rearIndex >= elements.length)
			throw new QueueOverflowException();
		elements[rearIndex++] = info;
	}

	// Return true if the array is empty; otherwise return false
	public boolean isEmpty() {
		if (rearIndex <= 0)
			return true;
		else
			return false;
	}

	// Return true if the array is full; otherwise return false
	public boolean isFull() {
		if (rearIndex >= elements.length)
			return true;
		else
			return false;
	}

	// Return number of elements
	public int size() {
		return rearIndex;
	}

	// Adjust elements array capacity with 'size'
	public void resize(int size) {
		T[] elementsRezied = (T[]) new Object[elements.length];

		for (int i = 0; i < elements.length; i++)
			elementsRezied[i] = elements[i];

		elements = (T[]) new Object[elements.length + size];

		for (int i = 0; i < elementsRezied.length; i++) {
			if (elementsRezied[i] != null)
				elements[i] = elementsRezied[i];
		}
	}

	// Creates and returns a string that correctly represents the current stack.
	public String toString() {
		String tempQueue = "Size: " + rearIndex + "\n";
		for (int i = 0; i < rearIndex; i++)
			tempQueue += elements[i] + "\n";
		return tempQueue;
	}

	// Return array capacity
	public int getQueueCapacity() {
		return elements.length;
	}
}
