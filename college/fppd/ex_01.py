import csv
import time
import numpy as np
import random
from concurrent.futures import ProcessPoolExecutor
from multiprocessing.shared_memory import SharedMemory


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


def search(arr, value):
    result = None
    for i in range(len(arr)):
        if arr[i] == value:
            result = i
    return result


def search_chunk(shared_name, length, value, start, chunk_size):
    shm = SharedMemory(name=shared_name)
    array = np.ndarray((length,), dtype=np.int32, buffer=shm.buf)

    end = min(start + chunk_size, length)
    for i in range(start, end):
        if array[i] == value:
            return i
    return None


def search_mp(arr, value, num_processes):
    length = len(arr)
    chunk_size = (length + num_processes - 1) // num_processes

    shm = SharedMemory(create=True, size=arr.nbytes)
    shared_array = np.ndarray(arr.shape, dtype=arr.dtype, buffer=shm.buf)
    shared_array[:] = arr[:]

    result = None
    with ProcessPoolExecutor(max_workers=num_processes) as executor:
        futures = [
            executor.submit(search_chunk, shm.name, length, value, i * chunk_size, chunk_size)
            for i in range(num_processes)
        ]

        for future in futures:
            if future.result() is not None:
                result = future.result()
                break

    shm.close()
    shm.unlink()

    return result


if __name__ == "__main__":
    NUM_PROCESSES = 4

    array = np.array(read_csv_elements('./data/C.csv'), dtype=np.int32)

    TARGET_VALUE = array[random.randint(0, len(array)-1)]
    print(f"TARGET_VALUE: {TARGET_VALUE}\n")

    start_time = time.perf_counter()
    index_serial = search(array, TARGET_VALUE)
    serial_time = time.perf_counter() - start_time
    print(f"SERIAL_SEARCH: \n- INDEX: {index_serial}\n- FOUND_VALUE: {array[index_serial]}\n- EXECUTION_TIME: {serial_time:.6f} SECONDS\n")

    start_time = time.perf_counter()
    index_parallel = search_mp(array, TARGET_VALUE, NUM_PROCESSES)
    parallel_time = time.perf_counter() - start_time
    print(f"PARALLEL_SEARCH: \n- INDEX: {index_parallel}\n- FOUND_VALUE: {array[index_parallel]}\n- EXECUTION_TIME: {parallel_time:.6f} SECONDS\n")

    assert array[index_serial] == array[index_parallel], "ERROR: THE VALUES FOUND BY THE PROCESSES ARE DIFFERENT"
    print(f"SPEEDUP: {serial_time / parallel_time:.2f}")
