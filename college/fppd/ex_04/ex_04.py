# Cumulative sum of previous elements
from threading import Thread
import time
import random

def prefix_sum_serial(A):
    B = [0] * len(A)
    B[0] = A[0]
    for i in range(1, len(A)):
        B[i] = B[i - 1] + A[i]
    return B

def prefix_sum_thread(A, B, start, end):
    B[start] = A[start]
    for i in range(start + 1, end):
        B[i] = B[i - 1] + A[i]

def prefix_sum_with_threads(A, num_threads=4):
    n = len(A)
    B = [0] * n
    threads = []
    chunk_size = n // num_threads

    for i in range(num_threads):
        start = i * chunk_size
        end = n if i == num_threads - 1 else (i + 1) * chunk_size
        thread = Thread(target=prefix_sum_thread, args=(A, B, start, end))
        threads.append(thread)
        thread.start()

    for thread in threads:
        thread.join()

    # Adjust global prefixes
    for i in range(1, num_threads):
        start = i * chunk_size
        offset = B[start - 1]
        for j in range(start, min((i + 1) * chunk_size, n)):
            B[j] += offset

    return B

def main():
    # Generate the array A with 50,000 random numbers
    A = [random.randint(1, 500000) for _ in range(50000)]

    # Serial computation
    start_time_serial = time.time()
    B_serial = prefix_sum_serial(A)
    time_serial = time.time() - start_time_serial

    # Parallel computation
    start_time_parallel = time.time()
    B_parallel = prefix_sum_with_threads(A)
    time_parallel = time.time() - start_time_parallel

    # Check if results are the same
    assert B_serial == B_parallel, "The serial and parallel results are different!"

    # Calculate speedup
    speedup = time_serial / time_parallel

    # Display the results
    print(f"Serial time: {time_serial:.5f} seconds")
    print(f"Parallel time: {time_parallel:.5f} seconds")
    print(f"Speedup: {speedup:.2f}")
    print("\nFirst 10 elements of vector A:", A[:10])
    print("\nFirst 10 elements of vector BSerial:", B_serial[:10])
    print("\nFirst 10 elements of vector BParallel:", B_parallel[:10])
    assert B_parallel == B_serial, "Error: Results do not match!"

# Run the program
if __name__ == "__main__":
    main()