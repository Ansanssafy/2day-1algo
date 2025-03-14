#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
  return *(int *)a - *(int *)b;
}

int main(void) {

  int N, M;
  scanf("%d%d", &N, &M);

  int *arr = (int *)malloc(N* sizeof(int));
  for (int i=0; i <N; i++) {
    scanf("%d", &arr[i]);
  }

  qsort(arr, N, sizeof(int), compare);

  int left = 0, right = N-1;
  int count = 0;

  while (left < right) {
    int sum = arr[left] + arr[right];

    if (sum==M) {
      count++;
      left++;
      right--;
    } else if (sum < M) {
      left++;
    } else {
      right--;
    }
  }

  printf("%d\n", count);

  return 0;
}