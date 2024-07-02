from sortedcontainers import SortedSet

n, k = map(int, input().split())
arr = list(map(int, input().split()))

s = SortedSet() # s는 각 점들의 위치를 저장하는 treeset
ans = SortedSet() # ans는 각 점의 양 끝점과의 거리를 저장하는 treeset

for el in arr:
    s.add(el)

idx = -1
for _ in range(k):
    print(s[idx], end = " ")
    idx -= 1