#pragma once
#pragma comment(lib,"pthreadVC2.lib")

#define _CRT_SECURE_NO_WARNINGS 1 
#define _WINSOCK_DEPRECATED_NO_WARNINGS 1
#define HAVE_STRUCT_TIMESPEC
#define MATRIX_SIZE 5
#define NUM_THREADS 8

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int threadBuffer = 0;
int** matrix;

void* threadFunc(void*);

int** createMatrix(int size) {
	int** matrix = (int**)malloc(size * sizeof(int*));
	int i;
	for (i = 0; i < size; i++) {
		matrix[i] = (int*)malloc(size * sizeof(int));
	}

	for (i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			matrix[i][j] = rand() % 32000;
			printf("%d\n", matrix[i][j]);
		}
	}
	return matrix;
}

int isPrime(int n) {
	if (n <= 1 || (n % 2 == 0 && n > 2)) return 0;
	double nRoot = sqrt(n);
	for (int i = 3; i < nRoot; i+=2) {
		if (n % i == 0) return 0;
	}
	return 1;
}

int matrixPrimeCounter(int height, int width, int i, int j) {
	int buffer = 0;

	for (int k = i ; k < width; k++) {
		for (int l = j; l < height; l++) {
			if (isPrime(matrix[k][l]) == 1) buffer++;
		}
	}
	return buffer;
}

int serialPrimeCounter() {
	return matrixPrimeCounter(MATRIX_SIZE, MATRIX_SIZE, 0, 0);
}

void threadMatrixPrimeCounter(int i) {
	int width = trunc(MATRIX_SIZE / NUM_THREADS) + 1;
	int previousColumnEnd = width * i;
	if (width + previousColumnEnd > MATRIX_SIZE) width = MATRIX_SIZE - previousColumnEnd;
	threadBuffer += matrixPrimeCounter(MATRIX_SIZE, width + previousColumnEnd, previousColumnEnd, 0);
	pthread_exit(0);
}

void parallelPrimeCounter() {

	threadBuffer = 0;

	pthread_t workers[NUM_THREADS];
	pthread_attr_t attr;
	pthread_attr_init(&attr);

	for (int i = 0; i < NUM_THREADS; i++) {
		pthread_create(&workers[i], &attr, threadMatrixPrimeCounter, i);
	}

	for (int i = 0; i < NUM_THREADS; i++) {
		pthread_join(workers[i], NULL);
	}

}

int main(int argc, char* argv[]) {

	
	int primes;
	double time_spent;

	printf("Comparacao entre um programa serial e um programa paralelo.\n");

	pthread_t thread;
	matrix = createMatrix(MATRIX_SIZE);

	// Começo do cálculo SERIAL
	clock_t begin = clock();

	primes = serialPrimeCounter();

	clock_t end = clock();
	time_spent = (double)(end - begin) / CLOCKS_PER_SEC;

	printf("Serial:\t\t %d prime numbers, took %lf seconds\n", primes, time_spent);

	// Começo do cálculo PARALELO
	begin = clock();

	parallelPrimeCounter();

	end = clock();
	time_spent = (double)(end - begin) / CLOCKS_PER_SEC;

	printf("Parallel:\t %d prime numbers, took %lf seconds", threadBuffer, time_spent);

	printf("\n");
	system("pause");
	return 0;
}