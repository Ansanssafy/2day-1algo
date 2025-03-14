#include <stdio.h>

int main(void) {
  int num[1000];
  int N, K;
  int cnt = 0;

  scanf("%d%d", &N, &K);

  for (int i = 2; i <= N; i++) 
  {
    num[i] = i;
  }

  for (int i = 2; i <= N; i++) {
    if (num[i] == 0) 
    {
      continue;
    }
    else
    {
      for (int j = i; j <= N; j += i)
      {
        if (num[j] != 0)
        {
          num[j] = 0;
          cnt++;
        }
        if (cnt == K)
        {
          printf("%d", j);
          break;
        }
      }
    }
  }

  return 0;
}