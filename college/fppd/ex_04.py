import multiprocessing
import csv
import time


def read_csv(file_path):
    with open(file_path, 'r') as file:
        reader = csv.reader(file)
        numbers = [int(float(row[0])) for row in reader]
    return numbers


def compute_prefix_sum(A, start_index, end_index, queue):
    B_chunk = []
    for i in range(start_index, end_index):
        if i == 0:
            B_chunk.append(A[0])
        else:
            B_chunk.append(A[i-1] + A[i])
    queue.put((start_index, B_chunk))


def parallel_prefix_sum(A, num_processes):
    chunk_size = len(A) // num_processes
    processes = []
    queue = multiprocessing.Queue()

    for i in range(num_processes):
        start_index = i * chunk_size
        end_index = (i + 1) * chunk_size if i < num_processes - 1 else len(A)
        process = multiprocessing.Process(
            target=compute_prefix_sum,
            args=(A, start_index, end_index, queue)
        )
        processes.append(process)
        process.start()

    result = [0] * len(A)
    for _ in processes:
        start_index, B_chunk = queue.get()
        for i, value in enumerate(B_chunk):
            result[start_index + i] = value

    for process in processes:
        process.join()

    return result


if __name__ == "__main__":
    csv_file = "data/C.csv"

    num_processes = 4

    A = read_csv(csv_file)
    print(f"Total de números carregados: {len(A)}")

    print("Executando soma de prefixos serial...")
    start_time = time.time()
    B_serial = parallel_prefix_sum(A, 1)
    end_time = time.time()

    serial_time = end_time - start_time
    print(f"Soma de Prefixos Serial completa. Tempo: {serial_time:.4f} segundos")

    print("Executando soma de prefixos paralela...")
    start_time = time.time()
    B_parallel = parallel_prefix_sum(A, num_processes)
    end_time = time.time()

    parallel_time = end_time - start_time
    print(f"Soma de Prefixos Paralela completa. Tempo: {parallel_time:.4f} segundos")

    # Calcular o speedup
    speedup = serial_time / parallel_time
    print(f"Speedup: {speedup:.2f}")

    # Verificar resultados
    if B_serial == B_parallel:
        print("Os resultados coincidem!")
    else:
        print("Os resultados NÃO coincidem! Verifique a implementação.")
        