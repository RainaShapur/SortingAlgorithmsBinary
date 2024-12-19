import java.util.Arrays;
import java.util.Random;

public class AllSorting {

    // Insertion Sort
    public static void insertionSort(int[] elements) {
        for (int j = 1; j < elements.length; j++) {
            int temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp < elements[possibleIndex - 1]) {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = temp;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] elements) {
        if (elements.length < 2) {
            return;
        }
        int mid = elements.length / 2;
        int[] left = Arrays.copyOfRange(elements, 0, mid);
        int[] right = Arrays.copyOfRange(elements, mid, elements.length);
        
        mergeSort(left);
        mergeSort(right);
        merge(elements, left, right);
    }

    private static void merge(int[] elements, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }
        while (i < left.length) {
            elements[k++] = left[i++];
        }
        while (j < right.length) {
            elements[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] sizes = {1000, 5000, 10000, 20000, 40000}; // Array sizes to test
        
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(100000) - 50000; // Random numbers between -50000 and 50000
            }
            
            System.out.println("Array Size: " + size);
            
            // Insertion Sort
            int[] insertionData = Arrays.copyOf(data, data.length);
            long start = System.currentTimeMillis();
            insertionSort(insertionData);
            long insertionTime = System.currentTimeMillis() - start;
            System.out.println("Insertion Sort Time: " + insertionTime + " ms");
            
            // Selection Sort
            int[] selectionData = Arrays.copyOf(data, data.length);
            start = System.currentTimeMillis();
            selectionSort(selectionData);
            long selectionTime = System.currentTimeMillis() - start;
            System.out.println("Selection Sort Time: " + selectionTime + " ms");
            
            // Merge Sort
            int[] mergeData = Arrays.copyOf(data, data.length);
            start = System.currentTimeMillis();
            mergeSort(mergeData);
            long mergeTime = System.currentTimeMillis() - start;
            System.out.println("Merge Sort Time: " + mergeTime + " ms");
            
            System.out.println("-------------------------------");
        }
    }
}
