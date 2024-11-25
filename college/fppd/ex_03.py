import multiprocessing
import random
import time


def calculate_element(i, j, A, B):
    return sum(A[i][k] * B[k][j] for k in range(len(A[0])))


def parallel_matrix_multiplication(A, B, num_processes=4):
    rows_A, cols_A = len(A), len(A[0])
    rows_B, cols_B = len(B), len(B[0])

    assert cols_A == rows_B, "ERROR: THE MATRICES CANNOT BE MULTIPLIED. INVALID DIMENSIONS."

    with multiprocessing.Pool(processes=num_processes) as pool:
        tasks = [(i, j, A, B) for i in range(rows_A) for j in range(cols_B)]
        results = pool.starmap(calculate_element, tasks)

    result_matrix = [results[i * cols_B:(i + 1) * cols_B] for i in range(rows_A)]
    return result_matrix


def serial_matrix_multiplication(A, B):
    rows_A, cols_A = len(A), len(A[0])
    rows_B, cols_B = len(B), len(B[0])

    assert cols_A == rows_B, "ERROR: THE MATRICES CANNOT BE MULTIPLIED. INVALID DIMENSIONS."

    result_matrix = [[sum(A[i][k] * B[k][j] for k in range(cols_A)) for j in range(cols_B)] for i in range(rows_A)]
    return result_matrix


if __name__ == "__main__":
    NUM_PROCESSES = 4

    rows_matrix_a, cols_matrix_a = 200, 400
    rows_matrix_b, cols_matrix_b = 400, 100

    A = [[random.randint(1, 10) for _ in range(cols_matrix_a)] for _ in range(rows_matrix_a)]
    B = [[random.randint(1, 10) for _ in range(cols_matrix_b)] for _ in range(rows_matrix_b)]

    start_time = time.perf_counter()
    serial_result_matrix = serial_matrix_multiplication(A, B)
    serial_time = time.perf_counter() - start_time
    print(f"SERIAL_MULTIPLICATION:\n- EXECUTION_TIME: {serial_time:.6f} SECONDS\n")

    start_time = time.perf_counter()
    parallel_result_matrix = parallel_matrix_multiplication(A, B, NUM_PROCESSES)
    parallel_time = time.perf_counter() - start_time

    print(f"PARALLEL_MULTIPLICATION:\n- EXECUTION_TIME: {parallel_time:.6f} SECONDS\n")

    assert serial_result_matrix == parallel_result_matrix, "ERROR: THE MATRICES ARE DIFFERENT"
    print(f"SPEEDUP: {serial_time / parallel_time:.2f}")
