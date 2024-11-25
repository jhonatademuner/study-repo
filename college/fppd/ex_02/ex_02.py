import numpy as np
import time
from multiprocessing import Pool


# Serial version of Bubble Sort
def bubble_sort_serial(arr):
    n = len(arr)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


# Helper function to perform Bubble Sort on a chunk
def bubble_sort_chunk(data):
    chunk, start_idx = data
    n = len(chunk)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if chunk[j] > chunk[j + 1]:
                chunk[j], chunk[j + 1] = chunk[j + 1], chunk[j]
    return chunk


# Parallel version of Bubble Sort
def bubble_sort_parallel(arr, num_processes):
    n = len(arr)
    chunk_size = n // num_processes
    chunks = [
        (arr[i * chunk_size : (i + 1) * chunk_size], i * chunk_size)
        for i in range(num_processes)
    ]

    # Sort each chunk in parallel
    with Pool(num_processes) as pool:
        sorted_chunks = pool.map(bubble_sort_chunk, chunks)

    # Combine the sorted chunks
    sorted_array = []
    for chunk in sorted_chunks:
        sorted_array.extend(chunk)

    # Perform final sorting on the combined array
    return bubble_sort_serial(sorted_array)


if __name__ == "__main__":
    # Parameters
    N = 50000  # Size of the array (adjusted for testing)
    NUM_PROCESSES = 4  # Number of processes for the parallel version

    # Generate random array
    array = np.random.randint(0, 100000, size=N)

    # Serial version
    print(f"Sorting an array of size {N} using Serial Bubble Sort...")
    start = time.perf_counter()
    sorted_serial = bubble_sort_serial(array.copy())
    serial_time = time.perf_counter() - start
    print(f"Serial execution time: {serial_time:.6f} seconds")

    # Parallel version
    print(f"Sorting an array of size {N} using Parallel Bubble Sort...")
    start = time.perf_counter()
    sorted_parallel = bubble_sort_parallel(array.copy(), NUM_PROCESSES)
    parallel_time = time.perf_counter() - start
    print(f"Parallel execution time: {parallel_time:.6f} seconds")
    print(f"Speedup: {serial_time / parallel_time:.2f}")

    # Consistency check
    assert np.array_equal(
        sorted_serial, np.sort(array)
    ), "Error: Serial Bubble Sort failed!"
    assert np.array_equal(
        sorted_parallel, np.sort(array)
    ), "Error: Parallel Bubble Sort failed!"
    print("Consistency check passed: Both versions sorted correctly.")
