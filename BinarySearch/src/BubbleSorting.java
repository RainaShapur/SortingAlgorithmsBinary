import java.util.Arrays;

public class BubbleSorting {

	public static void main(String[] args) {
		
		int n = 1000;
		int[] data = new int[n];
		
		for(int i = 0; i < data.length; i++) {
			data[i] = (int)(Math.random()*(23423523));
		}
		
		System.out.println(Arrays.toString(data));
		long start = System.nanoTime();
		bubbleSort(data);
		System.out.println("total time to sort: " + (System.nanoTime() - start));
		System.out.println(Arrays.toString(data));

	}
	
	
	/*
	 * sorts the array from the least to greatest
	 */

	public static void bubbleSort(int[] data) {
		
		//code to perform 1 - pass
		//write a piece of code that will check consecutive pairs
		//in data and swaps the values if they're out of order.
		
		boolean swap = true;
		
		for(int pass = 0; pass < data.length && swap; pass++) {
		
			swap = false;
			
			for(int i = 0; i < data.length-1; i++ ) {
				if(data[i] > data[i+1] ) { //out of order
					
					//perform swap between i and i + 1
					int temp  = data[i];
					data[i]   = data[i+1];
					data[i+1] = temp;
					//swap
					swap = true;
				} 
			}
		}
	}
}

