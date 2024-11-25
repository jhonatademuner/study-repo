import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class Ex02 {

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = Arrays.copyOfRange(array, left, mid + 1);
        int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) {
            array[k++] = L[i++];
        }

        while (j < n2) {
            array[k++] = R[j++];
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int left, right, threshold;

        public MergeSortTask(int[] array, int left, int right, int threshold) {
            this.array = array;
            this.left = left;
            this.right = right;
            this.threshold = threshold;
        }

        @Override
        protected void compute() {
            if (right - left + 1 <= threshold) {
                mergeSort(array, left, right);
            } else {
                int mid = left + (right - left) / 2;

                MergeSortTask leftTask = new MergeSortTask(array, left, mid, threshold);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, right, threshold);

                invokeAll(leftTask, rightTask);

                merge(array, left, mid, right);
            }
        }
    }

    public static void main(String[] args) {
        final int VECTOR_SIZE = 50000;
        final int NUM_THREADS = 4;

        Random random = new Random();
        int[] array = random.ints(VECTOR_SIZE, 0, 50000).toArray();

        int[] arrayCopy = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        mergeSort(arrayCopy, 0, arrayCopy.length - 1);
        long endTime = System.currentTimeMillis();
        double serialTime = (endTime - startTime) / 1000.0;
        System.out.printf("Time taken for serial merge sort: %f seconds%n", serialTime);

        int[] parallelArray = Arrays.copyOf(array, array.length);
        int threshold = VECTOR_SIZE / NUM_THREADS;

        startTime = System.currentTimeMillis();
        try (ForkJoinPool pool = new ForkJoinPool(NUM_THREADS)) {
            pool.invoke(new MergeSortTask(parallelArray, 0, parallelArray.length - 1, threshold));
        }
        endTime = System.currentTimeMillis();
        double parallelTime = (endTime - startTime) / 1000.0;
        System.out.printf("Time taken for parallel merge sort: %f seconds%n", parallelTime);

        double speedup = serialTime / parallelTime;
        System.out.printf("Speedup: %f%n", speedup);
    }
}