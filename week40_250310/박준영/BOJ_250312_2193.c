#include <stdio.h>

long long dp[91];

long long fibonacci(int n) {
  if (dp[n] != 0) return dp[n];

  dp[n] = fibonacci(n-1) + fibonacci(n-2);
  return dp[n];
}


int main(void) {

  int n;
  scanf("%d", &n);

  dp[1] = 1;
  dp[2] = 1;

  printf("%lld\n", fibonacci(n));
  
  return 0;
}