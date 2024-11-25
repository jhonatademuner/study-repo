#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>


void prefixSumSerial(int* A, int* B, int n) {
    B[0] = A[0];
    for (int i = 1; i < n; i++) {
        B[i] = B[i - 1] + A[i];
    }
}

// Parallel version using OpenMP
void prefixSumParallel(int* A, int* B, int n, int numThreads) {
    int chunkSize = n / numThreads;

    // Step 1: Compute prefix sum for each chunk in parallel
    #pragma omp parallel num_threads(numThreads)
    {
        int tid = omp_get_thread_num();
        int start = tid * chunkSize;
        int end = (tid == numThreads - 1) ? n : (tid + 1) * chunkSize;
        
        // Compute prefix sum for each chunk
        if (start == 0) {
            B[start] = A[start];
        } else {
            B[start] = A[start] + B[start - 1];
        }
        
        for (int i = start + 1; i < end; i++) {
            B[i] = B[i - 1] + A[i];
        }
    }

    // Step 2: Adjust each chunk based on the previous chunk's last value
    #pragma omp parallel for
    for (int i = 1; i < numThreads; i++) {
        int adjustValue = B[i * chunkSize - 1];
        for (int j = i * chunkSize; j < ((i + 1) * chunkSize < n ? (i + 1) * chunkSize : n); j++) {
            B[j] += adjustValue;
        }
    }
}

int main() {
    // Array size and number of threads
    int n = 50000;
    int numThreads = 4;

    // Initialize the array A with random values
    int* A = (int*)malloc(n * sizeof(int));
    int* BSerial = (int*)malloc(n * sizeof(int));
    int* BParallel = (int*)malloc(n * sizeof(int));

    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        A[i] = rand() % 10000;
    }

    // Serial execution
    clock_t startTime = clock();
    prefixSumSerial(A, BSerial, n);
    clock_t endTime = clock();
    double serialTime = (double)(endTime - startTime) / CLOCKS_PER_SEC;
    printf("Serial execution time: %.5f seconds\n", serialTime);

    // Parallel execution
    startTime = clock();
    prefixSumParallel(A, BParallel, n, numThreads);
    endTime = clock();
    double parallelTime = (double)(endTime - startTime) / CLOCKS_PER_SEC;
    printf("Parallel execution time: %.5f seconds\n", parallelTime);

    // Calculate speedup
    double speedup = serialTime / parallelTime;
    printf("Speedup: %.2f\n", speedup);

    // Free allocated memory
    free(A);
    free(BSerial);
    free(BParallel);

    return 0;
}
