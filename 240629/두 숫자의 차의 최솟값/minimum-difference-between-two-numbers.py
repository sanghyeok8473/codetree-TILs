import sys

n = int(input())
arr = list(map(int, input().split()))

min_val = sys.maxsize

for i in range(n - 1):
    for j in range(i + 1, n):
        min_val = min(min_val, abs(arr[i] - arr[j]))

print(min_val)