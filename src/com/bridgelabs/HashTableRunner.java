/****************************************************************
 * Purpose :Ability to remove "avoidable" from the paragraph.
 * @author Samarth BM

***************************************************************/

package com.bridgelabs;

public class HashTableRunner {

	public static void main(String[] args) {

		HashTableOperation<String, Integer> hashTable = new HashTableOperation<String, Integer>();
		String sentence = "Paranoids are not paranoid because they are paranoid but " +
                          "because they keep putting themselves deliberately into paranoid "+
				          "avoidable situations";

		// Storing given sentence in an array.
		// Converting the sentence to lower case and removing spaces.
		String[] sentenceArray = sentence.toLowerCase().split(" ");

		// Iterating over the array.
		for (String word : sentenceArray) {
			Integer count = hashTable.get(word);

			if (count == null)
				count = 1;
			else
				count = count + 1;
			hashTable.add(word, count);
		}
		// Removing word "avoidable"
		hashTable.remove("avoidable");
		// Displaying frequency.
		System.out.println(hashTable);

	}

}
