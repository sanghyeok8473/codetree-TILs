from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))

s = SortedSet() # s는 각 점들의 위치를 저장하는 treeset

for el in arr:
    if s.bisect_left(el) < el: # el이 들어왔을때, 여유 공간이 1개라도 있으면
        s.add(el)
    
print(len(s))