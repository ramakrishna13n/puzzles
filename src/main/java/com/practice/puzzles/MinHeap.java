package com.practice.puzzles;

import java.util.Arrays;

public class MinHeap {

	private int capacity = 10;
	private int size = 0;

	int items[] = new int[capacity];

	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	public void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
	}

	public void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}

	public int[] getHeap() {
		return items;
	}
	
	public int getCurrentHeapSize() {
		return size;
	}

	public static void main(String args[]) {
		MinHeap minHeap = new MinHeap();
		minHeap.add(-1);
		minHeap.add(2);
		minHeap.add(1);
		//minHeap.add(0);
		//minHeap.add(5);
		//minHeap.add(1);

		//System.out.println("Heap: " + Arrays.toString(minHeap.getHeap()));
		//System.out.println("Least Element: " + minHeap.peek());

		//minHeap.add(-1);

		//System.out.println("Heap: " + Arrays.toString(minHeap.getHeap()));
		//System.out.println("Least Element: " + minHeap.peek());

		//for (int i = 0; i < 3; i++) {
			//minHeap.poll();
		//}

		//System.out.println("Heap: " + Arrays.toString(minHeap.getHeap()));
		
		/*int minimumHeap[] = minHeap.getHeap();
		int maximumHeap[] = new int[minHeap.getCurrentHeapSize()];
		System.out.println("minimum Heap: "+ Arrays.toString(minimumHeap));
		System.out.println("Current Heap Size: "+ minHeap.getCurrentHeapSize());
		
		for(int i = minHeap.getCurrentHeapSize() -1,j = 0; i >=0; i--) {
			maximumHeap[j] = minimumHeap[i];
			j++;
		}
		
		System.out.println("Maximum Heap: "+ Arrays.toString(maximumHeap));*/
		
		minHeap.poll();
		System.out.println("minimum Heap: "+ minHeap.peek());
		
		minHeap.poll();
		System.out.println("minimum Heap: "+ minHeap.peek());
		
		minHeap.poll();
		System.out.println("minimum Heap: "+ minHeap.peek());
		
		
		
		//System.out.println("Forth Least Element: " + minHeap.peek());

		//minHeap.poll();

		//System.out.println("Fifth Least Element: " + minHeap.peek());

		//minHeap.poll();

		//System.out.println("Sixth Least Element: " + minHeap.peek() + " Current Heap Size: "+minHeap.getCurrentHeapSize());

		//minHeap.poll();

		//System.out.println("Seventh Least Element: " + minHeap.peek());

	}
}
