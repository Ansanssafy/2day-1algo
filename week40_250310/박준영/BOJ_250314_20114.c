#include <stdio.h>
#include <stdlib.h>

int main(void) {
  int N, H, W; // N = 문자열 길이, H = 세로로 번진 글자의 수, W = 가로로 번진 글자의 수
  scanf("%d%d%d", &N, &H, &W);

  
  char **arr = (char **)malloc(H * sizeof(char *));
  for (int i = 0; i < H; i++) {
    arr[i] = (char *)malloc((N * W + 1) * sizeof(char));
  }
  
  for (int i = 0; i < H; i++) {
    scanf("%s", arr[i]);
  }

  char *result = (char *)malloc((N+1)*sizeof(char));
  result[N] = '\0';

  for (int col = 0; col < N; col++) {
    result[col] = '?';
    for (int i = 0; i <H; i++) {
      for (int j = 0; j < W; j++) {
        char current = arr[i][col * W + j];
        if (current != '?') {
          result[col] = current;
          break;
        }
      }
      if (result[col] != '?') break;
    }
  }

  printf("%s\n", result);

  for (int i = 0; i < H; i++) {
    free(arr[i]);
  }
  free(arr);
  free(result);

  return 0;
}