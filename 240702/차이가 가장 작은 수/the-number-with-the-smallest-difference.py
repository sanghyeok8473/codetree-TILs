import sys
from sortedcontainers import SortedSet

# 변수 선언 및 입력:
n, m = map(int, input().split())

s = SortedSet()
min_val = sys.maxsize
s.add(int(input()))

for _ in range(n-1):
    el = int(input())
    idx = s.bisect_left(el)

    if idx != len(s): ## 이번에 들어올 값이 이전까지의 최대값보다는 작음
        while idx < len(s):
            if s[idx] - el >= m:
                break
            idx += 1
        min_val = min(min_val, s[idx] - el)
    
    idx = s.bisect_left(el) - 1
    while idx >= 0:
        if el - s[idx] >= m:
            break
        idx -= 1
    min_val = min(min_val, el - s[idx]) if el - s[idx] >= m else min_val

    s.add(el)

print(min_val if min_val != sys.maxsize else -1)