from sortedcontainers import SortedSet

# 변수 선언 및 입력:
n, m = tuple(map(int, input().split()))
arr = list(map(int, input().split()))
q = list(map(int, input().split()))

s = SortedSet(arr)

for el in q:
    idx = s.bisect_right(el)
    idx -= 1
    if idx >= 0:
        print(s[idx])
        s.remove(s[idx])
    else:
        print(-1)