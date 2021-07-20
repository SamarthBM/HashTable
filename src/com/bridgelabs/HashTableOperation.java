/****************************************************************
 * Purpose : To create methods for Hash table features.
 * @author Samarth BM

***************************************************************/

package com.bridgelabs;

import java.util.ArrayList;

public class HashTableOperation<K, V> {

	MyMapNode head;
	MyMapNode tail;
	private final int numOfBuckets;
	ArrayList<MyMapNode<K, V>> myBucketArray;

	public HashTableOperation() {
		this.numOfBuckets = 10;
		this.myBucketArray = new ArrayList<>();
		// Creating empty linked list.
		for (int i = 0; i < numOfBuckets; i++)
			this.myBucketArray.add(null);
	}

	/*
	 * Purpose: Method to get the word from Linked List using index number.
	 * 
	 * @param word: word returned.
	 */
	public V get(K word) {
		int index = this.getBucketIndex(word);
		if (this.myBucketArray.get(index) == null)
			return null;
		MyMapNode<K, V> myNode = searchNode(word);
		return (myNode == null) ? null : myNode.getValue();
	}

	/*
	 * Purpose: Method to search word from Linked List.
	 * 
	 * @param word: word to search.
	 */
	public MyMapNode<K, V> searchNode(K word) {
		MyMapNode<K, V> currentNode = head;
		int position = 0;
		while (currentNode != null) {
			position++;
			if (currentNode.getKey().equals(word)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	/*
	 * Purpose: Method to add key and value to hash table using index number.
	 * 
	 * @param key: word to be added.
	 * 
	 * @param value: frequency of word.
	 */
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyMapNode<K, V> myNode = this.myBucketArray.get(index);
		if (myNode == null) {
			myNode = new MyMapNode<>(key, value);
			this.myBucketArray.set(index, myNode);
		}
		myNode = searchNode(key);
		if (myNode == null) {
			myNode = new MyMapNode<>(key, value);
			this.append(myNode);
		} else
			myNode.setValue(value);

	}

	/*
	 * Purpose: Method to append value to Linked List.
	 * 
	 * @param myNode: value to append.
	 */

	private void append(MyMapNode<K, V> myNode) {
		if (this.head == null)
			this.head = myNode;
		if (this.tail == null)
			this.tail = myNode;
		else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	/*
	 * Purpose: Method to get the index number of key.
	 * 
	 * @param word: index to be found.
	 */
	public int getBucketIndex(K word) {
		int hashCode = Math.abs(word.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes{" + head + '}';
	}

}
