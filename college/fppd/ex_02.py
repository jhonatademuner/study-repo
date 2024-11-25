import numpy as np
import time
import csv
from multiprocessing import Pool


def read_csv_elements(file_path):
    try:
        with open(file_path, mode='r', newline='', encoding='utf-8') as file:
            csv_reader = csv.reader(file)
            # Flatten and convert elements to integers
            elements = [
                int(float(element))
                for row in csv_reader
                for element in row
                if element.strip()  # Skip empty values
            ]
        return elements
    except FileNotFoundError:
        raise FileNotFoundError(f"File not found: {file_path}")
    except ValueError as e:
        raise ValueError(f"Invalid data format in the file: {e}")


def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result


def serial_merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = serial_merge_sort(arr[:mid])
    right = serial_merge_sort(arr[mid:])
    return merge(left, right)


def parallel_merge_sort(arr, num_processes):
    length = len(arr)
    if length <= 1:
        return arr
    chunk_size = (length + num_processes - 1) // num_processes
    chunks = [
        arr[i * chunk_size: min((i + 1) * chunk_size, length)]
        for i in range(num_processes)
    ]
    
    with Pool(num_processes) as pool:
        sorted_chunks = pool.map(serial_merge_sort, chunks)
    
    while len(sorted_chunks) > 1:
        new_chunks = []
        for i in range(0, len(sorted_chunks), 2):
            if i + 1 < len(sorted_chunks):
                new_chunks.append(merge(sorted_chunks[i], sorted_chunks[i+1]))
            else:
                new_chunks.append(sorted_chunks[i])
        sorted_chunks = new_chunks
    
    return sorted_chunks[0]


if __name__ == "__main__":
    NUM_PROCESSES = 4
    file_path = "data/C.csv"

    array = np.array(read_csv_elements(file_path), dtype=np.int32)

    start_time = time.perf_counter()
    sorted_sequential = serial_merge_sort(array.copy())
    sequential_time = time.perf_counter() - start_time
    print(f"SERIAL_SORTING:\n- EXECUTION_TIME: {sequential_time:.6f} SECONDS\n")

    start_time = time.perf_counter()
    sorted_parallel = parallel_merge_sort(array.copy(), NUM_PROCESSES)
    parallel_time = time.perf_counter() - start_time
    print(f"PARALLEL_SORTING:\n- EXECUTION_TIME: {parallel_time:.6f} SECONDS\n")
    
    assert np.array_equal(sorted_sequential, sorted_parallel), "ERROR: THE ARRAYS DONT MATCH"
    print(f"SPPEDUP: {sequential_time / parallel_time:.2f}")
    