#include "stack.h"
#include <stdio.h>
#include <stdlib.h>

int main(void) {
  Stack *s = create();
  push(s, 'a');
  push(s, 'b');
  push(s, 'c');
  print(s);
  char v = pop(s);
  print(s);
  printf("topo=%c\n", v);
  return 0;
}