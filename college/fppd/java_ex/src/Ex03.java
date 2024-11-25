import java.util.*;
import java.util.concurrent.*;

public class Ex03 {

    // Optimized matrix multiplication using ForkJoinPool
    public static int[][] multiplyMatricesOptimized(int[][] A, int[][] B, int numThreads) throws InterruptedException, ExecutionException {
        int rowsA = A.length;
        int colsB = B[0].length;

        // Create a ForkJoinPool for task parallelism
        ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);
        int chunkSize = (rowsA + numThreads - 1) / numThreads;  // ceil division

        // Create a list of tasks for matrix chunks
        List<RecursiveTask<int[][]>> tasks = new ArrayList<>();

        // Divide matrix A into chunks and submit tasks to ForkJoinPool
        for (int i = 0; i < numThreads; i++) {
            int startRow = i * chunkSize;
            int endRow = Math.min((i + 1) * chunkSize, rowsA);

            final int[][] AChunk = new int[endRow - startRow][B[0].length];
            System.arraycopy(A, startRow, AChunk, 0, endRow - startRow);

            final int[][] BCopy = B;
            tasks.add(new RecursiveTask<int[][]>() {
                @Override
                protected int[][] compute() {
                    return multiplyChunk(AChunk, BCopy, colsB);
                }
            });
        }

        // Fork each task separately and collect futures
        List<Future<int[][]>> futures = new ArrayList<>();
        for (RecursiveTask<int[][]> task : tasks) {
            futures.add(forkJoinPool.submit(task));
        }

        // Collect results and combine them into the final result
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < futures.size(); i++) {
            int[][] chunkResult = futures.get(i).get();
            int startRow = i * chunkSize;
            int endRow = Math.min((i + 1) * chunkSize, rowsA);
            System.arraycopy(chunkResult, 0, result, startRow, endRow - startRow);
        }

        forkJoinPool.shutdown();
        return result;
    }

    // Parallel chunk multiplication
    public static int[][] multiplyChunk(int[][] AChunk, int[][] B, int colsB) {
        int[][] resultChunk = new int[AChunk.length][colsB];

        // Reorder loops for cache-friendly memory access
        for (int i = 0; i < AChunk.length; i++) {
            for (int k = 0; k < AChunk[i].length; k++) {
                for (int j = 0; j < colsB; j++) {
                    resultChunk[i][j] += AChunk[i][k] * B[k][j];
                }
            }
        }

        return resultChunk;
    }

    // Serial matrix multiplication
    public static int[][] multiplyMatricesSerial(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Random random = new Random();

        int rowsA = 200, colsA = 400;
        int rowsB = 400, colsB = 100;

        // Generate random matrices
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = random.nextInt(10) + 1;
            }
        }

        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = random.nextInt(10) + 1;
            }
        }

        // Serial multiplication
        long startSeq = System.nanoTime();
        int[][] resultSeq = multiplyMatricesSerial(A, B);
        long endSeq = System.nanoTime();
        double timeSeq = (endSeq - startSeq) / 1e9;
        System.out.printf("Serial - Time: %.5f seconds%n", timeSeq);

        // Parallel multiplication
        int numThreads = 4;  // Adjust the number of threads based on available processors
        long startPar = System.nanoTime();
        int[][] resultPar = multiplyMatricesOptimized(A, B, numThreads);
        long endPar = System.nanoTime();
        double timePar = (endPar - startPar) / 1e9;
        System.out.printf("Parallel - Time: %.5f seconds%n", timePar);

        // Speedup calculation
        double speedup = timeSeq / timePar;
        System.out.printf("Speedup achieved: %.2f%n", speedup);

        // Consistency check
        if (!Arrays.deepEquals(resultSeq, resultPar)) {
            System.out.println("Error: Results do not match!");
        } else {
            System.out.println("Results match.");
        }
    }
}
