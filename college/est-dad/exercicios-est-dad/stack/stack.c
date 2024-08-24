#include "stack.h"
#include <stdlib.h>
#include <stdio.h>

// PILHA FILO (First In, Last Out)

struct stack {
  StackNode *top;
};

struct stack_node {
  char info;
  StackNode *next;
};

Stack* create() {
    Stack*s = (Stack*) malloc(sizeof(Stack));
    s->top = NULL;
    return s;
}


void push(Stack *s, char v) {
  StackNode *node = (StackNode *)malloc(sizeof(StackNode));
  node->info = v;
  node->next = s->top;
  s->top = node;
}

char pop(Stack *s) {                //          a b c d e
  if (s->top != NULL) {             //          a b c d e
    StackNode *p = s->top;          //          a b c d e       a
    s->top = p->next;               //            b c d e       a 
    char ans = p->info;             //            b c d e       a->info
    free(p);                        //            b c d e                   
    return ans;                     //                          ans = a->info
  }                                 //        
  return -1;                        //                          throw error
}

int is_empty(Stack *s) { return s->top == NULL; }

void clear(Stack *s) {
  while (!is_empty(s)) {
    pop(s);
  }
}

void print(Stack *s) {
  for (StackNode *p = s->top; p != NULL; p = p->next) {
    printf("%c ", p->info);
  }
    printf("\n");
}