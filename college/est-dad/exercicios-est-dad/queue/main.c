#include "queue.h"
#include <stdio.h>

int main(void) {
  Queue *q = queue_create();
  queue_insert(q, 1);
  queue_insert(q, 2);
  queue_insert(q, 3);
  queue_print(q);
  queue_remove(q);
  queue_print(q);
  int v = queue_peek(q);
  queue_print(q);
  printf("front=%d\n", v);
  queue_insert(q, 1);
  queue_print(q);
  return 0;
}