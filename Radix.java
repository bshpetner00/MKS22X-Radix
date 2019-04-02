import java.util.*;

public class Radix {

	public static void main(String[] args) {
		
	}

	private static int getDigit(int val, int column) {
		String fake = "" + val;
		if (fake.length()-(1+column) >= 0) {
			char digit = fake.charAt(fake.length()-(1+column));
			int dig = Character.getNumericValue(digit);
			return dig;	
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public static void radixsort(int[]data) {
		MyLinkedList[] buckets = new MyLinkedList[20]; //bucket holder, array of linkedlists
		MyLinkedList betterData = new MyLinkedList(); //data holder, normal linkedlist
 		for (int i = 0; i < buckets.length; i++) { //initialize buckets
 			buckets[i] = new MyLinkedList(); 
 		}
 		int valToken = 0; //the largest value, used to find number of total needed passes
 		for (int j = 0; j < data.length; j++) { //initialize betterData, also set valToken
 			betterData.add(data[j]);
 			if (data[j] > valToken) {
 				valToken = data[j];
 			}
 		}
 		int numPasses = 0;
 		while (valToken > 0) { //now we know exactly how many times we must go through the data to get all columns
 			valToken /= 10;
 			numPasses++;
 		}
 		for (int k = 0; k < numPasses; k++) { //we now have the number of passes, and a linkedlist of our array. At this point we need to start sorting numbers into buckets for each iteration of the K loop
 			Node node = betterData.start;
 			while (node.hasNext()) {
 				int nodeValue = node.getData();
 				if (nodeValue >= 0) {
 					buckets[k+10].add(getDigit(nodeValue,k));
 				}
 				else {
 					buckets[k-9].add(getDigit(nodeValue,k));
 				}
 			}
 		}
 		//once we have our sorted buckets, we re-merge

	}
}