#ifndef QUEUE_H
#define QUEUE_H

typedef struct queue Queue;

Queue* queue_create();
void queue_insert(Queue* q, int v);
int queue_peek(Queue* q);
int queue_remove(Queue* q);
int queue_is_empty(Queue* q);
void queue_free(Queue* q);
void queue_print(Queue *q);

#endif