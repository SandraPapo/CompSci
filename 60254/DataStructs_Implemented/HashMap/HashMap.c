#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAPLENGTH 16

typedef struct HashEntry {
	char *key;
	char *value;
	struct HashEntry *next;
	int hash;
} HashEntry;

typedef struct List {
	HashEntry *head;
	HashEntry *tail;
	int length;
} List;

typedef struct HashMap {
	List entries[MAPLENGTH];
}HashMap;

HashMap *newMap();
void put(char *key, char *value, HashMap *map);
char* get(char *key, HashMap *map);
int hashCode(char *key);



HashMap *newMap() {
	HashMap *map; 
	map = malloc(sizeof(HashMap));
	return map;
}

void put(char *key, char *value, HashMap *map) {
	HashEntry *current;
	current = malloc(sizeof(HashEntry));
	current -> key = key;
	current -> value = value;
	current -> next = NULL;
	current -> hash = hashCode(key);

}

HashEntry *getEntry(int index, HashMap *map) {
	return map -> (entries + index);
}

char* get(char *key, HashMap *map) {
	int index = hashCode(key) % MAPLENGTH;
	HashEntry *current = getEntry(index, map);
	while(current != NULL) {
		if(current -> key == key) {
			return current -> value;
		}
		current = current -> next;
	}
	return NULL;
}

int hashCode(char *key) {
	int a = strlen(key);
	int b = a;
	while(a > 0) {
		b += a / 2;
		a /= 2;
	}
	return b;
}

int main() {
	//HashEntry *what;
	return 0;
}