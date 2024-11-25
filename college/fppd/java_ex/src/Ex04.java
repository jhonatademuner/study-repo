import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Random;

public class Ex04 {

    // Serial version
    public static int[] prefixSumSerial(int[] A) {
        int[] B = new int[A.length];
        B[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] + A[i];
        }
        return B;
    }

    // Parallel version helper method
    private static void partialPrefixSum(int[] A, int[] B, int start, int end) {
        if (start == 0) {
            B[start] = A[start];
        } else {
            B[start] = A[start] + B[start - 1];
        }
        for (int i = start + 1; i < end; i++) {
            B[i] = B[i - 1] + A[i];
        }
    }

    // Parallel version
    public static int[] prefixSumParallel(int[] A) {
        int[] B = new int[A.length];
        int numWorkers = 4;
        int chunkSize = A.length / numWorkers;

        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < numWorkers; i++) {
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            if (i == numWorkers - 1) {
                end = A.length;
            }

            final int segmentStart = start;
            final int segmentEnd = end;
            futures.add(executor.submit(() -> partialPrefixSum(A, B, segmentStart, segmentEnd)));
        }

        // Wait for all tasks to finish
        for (Future<?> future : futures) {
            try {
                future.get();  // Wait for task completion
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Adjust prefixes for each segment
        for (int i = 1; i < numWorkers; i++) {
            int adjustValue = B[i * chunkSize - 1];
            for (int j = i * chunkSize; j < Math.min((i + 1) * chunkSize, A.length); j++) {
                B[j] += adjustValue;
            }
        }

        executor.shutdown();
        return B;
    }

    public static void main(String[] args) {
        // Generate random array A
        Random rand = new Random();
        int[] A = new int[50000];
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(10000);
        }

        // Serial execution
        long startTime = System.nanoTime();
        int[] BSerial = prefixSumSerial(A);
        long endTime = System.nanoTime();
        double serialTime = (endTime - startTime) / 1e9;
        System.out.printf("Tempo de execução serial: %.5f segundos\n", serialTime);

        // Parallel execution
        startTime = System.nanoTime();
        int[] BParallel = prefixSumParallel(A);
        endTime = System.nanoTime();
        double parallelTime = (endTime - startTime) / 1e9;
        System.out.printf("Tempo de execução paralela: %.5f segundos\n", parallelTime);

        // Speedup
        double speedup = serialTime / parallelTime;
        System.out.printf("Speedup: %.2f\n", speedup);
    }
}
