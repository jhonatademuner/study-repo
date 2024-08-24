 #include "queue.h"
#include <stdio.h>
#include <stdlib.h>

// LISTA = FIFO (First In, First Out)

typedef struct queue_node QueueNode;

struct queue
{
    QueueNode *front;
    QueueNode *rear;
};

struct queue_node
{
    int info;
    QueueNode *next;
};

Queue *queue_create()
{
    Queue *q = (Queue *)malloc(sizeof(Queue)); // create a new queue
    q->front = NULL;                           // keep structure integrity
    q->rear = NULL;                            // keep structure integrity
    return q;                                  // return the pointer to the queue
}

void queue_insert(Queue *q, int v)
{
    QueueNode *node = (QueueNode *)malloc(sizeof(QueueNode)); // create a new node
    node->info = v;                                           // store the value
    node->next = NULL;                                        // keep structure integrity
    if (queue_is_empty(q))                                    // if the queue is empty
        q->front = node;                                     // keep structure integrity
    else
        q->rear->next = node; // keep structure integrity  a -> b -> c -> d -> e -> node
    q->rear = node;           // keep structure integrity
}


// a-> b-> c-> d-> e-> f-> node

// a

// a b c d e f

int queue_peek(Queue *q)
{
    if (queue_is_empty(q))
    {                                         // if the queue is empty
        printf("Error: the queue is empty!"); // throw error
        return -1;                            // return an invalid value
    }
    return q->front->info; // return the value of the first node
}

int queue_remove(Queue *q)
{
    if (queue_is_empty(q))
    {                                         // if the queue is empty
        printf("Error: the queue is empty!"); // throw error
        return -1;                            // return an invalid value
    }

    // store the pointer to the first node and the value to be returned
    QueueNode *p = q->front;
    int val = p->info;

    // keep structure integrity
    q->front = q->front->next;              // a -> b -> c -> d -> e
    if (q->front == NULL)
        q->rear = NULL;
    free(p);
    return val;
}

int queue_is_empty(Queue *q) { return q->front == NULL; }

void queue_free(Queue *q)
{
    while (!queue_is_empty(q))
        queue_remove(q);
}

void queue_print(Queue *q)
{
    for (QueueNode *p = q->front; p != NULL; p = p->next)
    {
        printf("%d ", p->info);
    }
    printf("\n");
}