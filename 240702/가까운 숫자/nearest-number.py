from sortedcontainers import SortedSet

n = int(input())
arr = list(map(int, input().split()))

s = SortedSet() # s는 각 점들의 위치를 저장하는 treeset
s.add(0)
for el in arr:
    s.add(el)
    min_val = 1000000
    for val in s:
        left_idx = s.bisect_right(val) # val보다 큰 최초의 위치를 찾는다.
        right_idx = left_idx - 1 # 바로 직전의 위치를 구한다.
        
        if left_idx < len(s):
            min_val = min(min_val, s[left_idx] - s[right_idx])
    print(min_val)