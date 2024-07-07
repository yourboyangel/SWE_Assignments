import java.util.Arrays;
import java.util.Random;

// Exercise 10
public class HeapSort {
    public static void heapSort(int[] arr){
        int n=arr.length;

        for(int i=n/2-1;i>=0;i--){
            heap(arr,n,i);
        }

        for(int i=n-1; i>0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heap(arr,i,0);
        }
    }

    static void heap(int[] arr, int n, int i){
        int biggest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left]>arr[biggest])
            biggest = left;

        if(right<n && arr[right]>arr[biggest])
            biggest=right;

        if(biggest!=i){
            int temp=arr[i];
            arr[i]=arr[biggest];
            arr[biggest]=temp;

            heap(arr,n,biggest);
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int[] randomArrayGenerator(int size){
        int[] arr= new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        // Array sizes to test
        int[] arraySizes = {1000, 5000, 10000};


        for (int size : arraySizes) {
            System.out.println("Array size: " + size);
            int[] arr1 = randomArrayGenerator(size);
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();
            int[] arr4 = arr1.clone();


            long startHeapSort = System.currentTimeMillis();
            heapSort(arr1);
            long endHeapSort = System.currentTimeMillis();
            System.out.println("Heap Sort: " + (endHeapSort - startHeapSort) + " ms");


            long startInsertionSort = System.currentTimeMillis();
            insertionSort(arr2);
            long endInsertionSort = System.currentTimeMillis();
            System.out.println("Insertion Sort: : " + (endInsertionSort - startInsertionSort) + " ms");


            long startMergeSort = System.currentTimeMillis();
            mergeSort(arr3);
            long endMergeSort = System.currentTimeMillis();
            System.out.println("Merge Sort: " + (endMergeSort - startMergeSort) + " ms");


            long startQuickSort = System.currentTimeMillis();
            quickSort(arr4, 0, arr4.length - 1);
            long endQuickSort = System.currentTimeMillis();
            System.out.println("Quick Sort: " + (endQuickSort - startQuickSort) + " ms");

            System.out.println();
        }
    }


}
