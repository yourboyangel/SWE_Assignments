import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSortTester {
    public static void main(String[] args) {
        int[] arraySizes = {10000, 50000, 100000, 1000000};

        System.out.println("Size    Sequential  Parallel ");
        for (int size : arraySizes) {
            int[] array = createRandomArray(size);

            long start = System.currentTimeMillis();
            sequentialMergeSort(array);
            long end = System.currentTimeMillis();
            long sequentialTime = end - start;

            array = createRandomArray(size);
            start = System.currentTimeMillis();
            parallelMergeSort(array);
            end = System.currentTimeMillis();
            long parallelTime = end - start;

            System.out.printf("%d     %d            %d%n", size, sequentialTime, parallelTime);

        }
    }
        public static void sequentialMergeSort(int[] array){
            Arrays.sort(array);
        }
        public static void parallelMergeSort(int[] array) {
            ParallelMergeSort mergeSort = new ParallelMergeSort(array, 0, array.length - 1);
            ForkJoinPool pool = new ForkJoinPool();
            pool.invoke(mergeSort);
        }
        public static int[] createRandomArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * size);
            }
            return array;
        }
    }

