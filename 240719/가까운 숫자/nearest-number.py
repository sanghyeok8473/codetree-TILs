from sortedcontainers import SortedSet

n = int(input())
arr = list(map(int, input().split()))

s = SortedSet() # s는 각 점들의 위치를 저장하는 treeset
s.add(0)
ans = SortedSet() # ans는 각 점의 양 끝점과의 거리를 저장하는 treeset

for el in arr:
    s.add(el)
    idx = s.bisect_right(el)
    if idx < len(s): # el이 가장 큰 숫자가 아니면
        ans.add((s[idx] - s[idx - 1])) # 추가된 숫자 바로 오른쪽 숫자 - 추가된 숫자
        ans.add((s[idx - 1] - s[idx - 2])) # 추가된 숫자 - 추가된 숫자 바로 왼쪽 숫자
    else : # 지금 추가된 el이 가장 큰 숫자면
        ans.add((s[-1] - s[-2])) # 가장 큰 숫자(추가된 숫자) - 추가된 숫자 바로 왼쪽 숫자
    print(ans[0])

# 3 9 2