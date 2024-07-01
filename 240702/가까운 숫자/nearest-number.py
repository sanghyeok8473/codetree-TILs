from sortedcontainers import SortedSet

n = int(input())
arr = list(map(int, input().split()))
s = SortedSet() # s는 각 점의 좌표를 저장하는 treeset
ans = SortedSet() # ans는 각 점끼리의 거리들을 저장하는 treeset
s.add(0)

for el in arr:
    s.add(el)
    for val in s:
        ans.add(abs(el - val))
    print(ans[1])