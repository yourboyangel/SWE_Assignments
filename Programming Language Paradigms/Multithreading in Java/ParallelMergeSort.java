import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {
    private final int[] nums;
    private final int low;
    private final int high;

    public ParallelMergeSort(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low < high) {
            int middle = (high + low) / 2;

            ParallelMergeSort left = new ParallelMergeSort(nums, low, middle);
            ParallelMergeSort right = new ParallelMergeSort(nums, middle + 1, high);
            invokeAll(left, right);
            merge(nums, low, middle, high);
        }
    }

    private static void merge(int arr[], int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < rightSize; ++j)
            rightArray[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {23, 12, 4, 1, 15, 24, 7, 14, 12, 33, 1, 8, 17};
        System.out.println("Array: " + Arrays.toString(nums));

        ParallelMergeSort sorting = new ParallelMergeSort(nums, 0, nums.length - 1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(sorting);

        System.out.println("Sorted: " + Arrays.toString(nums));
    }
}
