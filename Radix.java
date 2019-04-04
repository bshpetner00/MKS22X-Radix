import java.util.*;

public class Radix {
	

	public static void main(String[] args) {
		int[] data = {-9,0,-8,9,-7,11,-8,-2,7,3,3,4,5,6,2,-13,-1,0,4,-5,0,3};
		//System.out.println(""+getDigit(19,0));
		//System.out.println(""+getDigit(-19,0));
		//System.out.println(Arrays.toString(data));
		radixsort(data);
		System.out.print(Arrays.toString(data));
	}

	private static int getDigit(int val, int column) {
		int res = val / (int) Math.pow(10, column) % 10; //take the number, divide it by the factor of ten needed to isolate the chosen column, and then mod that value by 10 to get the final remainder. 
		if (val < 0) {
			return res*-1;
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public static void radixsort(int[]data) {
		if (data.length != 0) {
			MyLinkedList<Integer>[] buckets = new MyLinkedList[20]; //bucket holder, array of linkedlists
			MyLinkedList<Integer> betterData = new MyLinkedList(); //data holder, normal linkedlist
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
				Node<Integer> node = betterData.start;
				for (int noder = 0; noder < data.length; noder++) {
					int nodeValue = (int) node.getData();
					if (nodeValue >= 0) {
						buckets[getDigit(nodeValue,k)+10].add(nodeValue);
					}
					else {
						buckets[9-getDigit(nodeValue,k)].add(nodeValue);
					}
					node = node.next();
				}
				betterData.clear();
				for (int l = 0; l < 20; l++) {
					betterData.extend(buckets[l]);
				}
				for (int i = 0; i < buckets.length; i++) { //initialize buckets
					buckets[i] = new MyLinkedList(); 
				}
			}
			//System.out.println()
			for (int m = 0; m < data.length; m++) { //empty out our now fully sorted linkedlist back into OG
				data[m] = betterData.removeFirst();
			}
		}
	}
}