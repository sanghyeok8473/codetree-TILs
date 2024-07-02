import sys
from sortedcontainers import SortedSet

# 변수 선언 및 입력:
n, m = map(int, input().split())

s = SortedSet()
min_val = sys.maxsize
s.add(int(input()))

for _ in range(n-1):
    el = int(input())
    idx = s.bisect_right(el)

    if idx == len(s): ## 이번에 들어올 값이 이전까지의 최대값보다 큼
        min_val = min(min_val, el - s[idx - 1]) if el - s[idx - 1] >= m else min_val
        s.add(el)
    else: # 이번에 들어온 값보다 큰 값이 이미 있음
        min_val = min(min_val, s[idx] - el) if s[idx] - el >= m else min_val
        s.add(el)

print(min_val)