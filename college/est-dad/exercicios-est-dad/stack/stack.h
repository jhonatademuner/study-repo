#ifndef STACK_H
#define STACK_H

typedef struct stack Stack;
typedef struct stack_node StackNode;

Stack* create();
void push(Stack *s, char v);
char pop(Stack *s);
int is_empty(Stack *s);
void clear(Stack *s);
void print(Stack *s);

#endif