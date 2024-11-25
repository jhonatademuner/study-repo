import multiprocessing
import random
import time


def calculate_element(i, j, A, B):
    # Calculate the element C[i][j] in the matrix multiplication A * B.
    return sum(A[i][k] * B[k][j] for k in range(len(A[0])))


def parallel_matrix_multiplication(A, B, num_proc=4):
    # Perform parallel matrix multiplication using multiprocessing.
    rows_A, cols_A = len(A), len(A[0])
    rows_B, cols_B = len(B), len(B[0])

    if cols_A != rows_B:
        raise ValueError("As matrizes não podem ser multiplicadas. Dimensões inválidas.")

    # Create a pool of workers
    with multiprocessing.Pool(processes=num_proc) as pool:
        # Each worker computes a row of the result matrix C
        tasks = [(i, j, A, B) for i in range(rows_A) for j in range(cols_B)]
        results = pool.starmap(calculate_element, tasks)

    # Construct matrix C from the results
    C = [results[i * cols_B:(i + 1) * cols_B] for i in range(rows_A)]
    return C


def sequential_matrix_multiplication(A, B):
    # Perform sequential matrix multiplication of A and B.
    rows_A, cols_A = len(A), len(A[0])
    rows_B, cols_B = len(B), len(B[0])

    if cols_A != rows_B:
        raise ValueError("As matrizes não podem ser multiplicadas. Dimensões inválidas.")

    # Multiply matrices A and B sequentially
    C = [[sum(A[i][k] * B[k][j] for k in range(cols_A)) for j in range(cols_B)] for i in range(rows_A)]
    return C


if __name__ == "__main__":
    # Matrix dimensions
    rows_A, cols_A = 200, 400
    rows_B, cols_B = 400, 100
    
    # Number of processes for parallel computation
    num_proc = 4

    # Generate random matrices
    A = [[random.randint(1, 10) for _ in range(cols_A)] for _ in range(rows_A)]
    B = [[random.randint(1, 10) for _ in range(cols_B)] for _ in range(rows_B)]

    # Sequential multiplication
    start_seq = time.perf_counter()
    C_seq = sequential_matrix_multiplication(A, B)
    end_seq = time.perf_counter()

    # Parallel multiplication
    start_par = time.perf_counter()
    C_par = parallel_matrix_multiplication(A, B, num_proc=num_proc)
    end_par = time.perf_counter()

    # Results
    print(f"Sequencial - Tempo: {end_seq - start_seq:.5f} segundos")
    print(f"Paralela - Tempo: {end_par - start_par:.5f} segundos")

    # Calculate speedup
    speedup = (end_seq - start_seq) / (end_par - start_par)
    print(f"Speedup alcançado: {speedup:.2f}")
