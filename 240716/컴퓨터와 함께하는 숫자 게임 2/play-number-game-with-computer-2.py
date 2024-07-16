import sys

m = int(input())

a, b = map(int, input().split())

min_val = sys.maxsize
max_val = -sys.maxsize

# 게임이 가장 적게 지속되는 경우: 

for i in range(a, b + 1):
    left, right, cnt = 1, m, 1

    while left <= right:
        mid = (left + right) // 2

        if mid == i:
            break
        elif mid > i:
            right = mid - 1
            cnt += 1
        else:
            left = mid + 1
            cnt += 1
    
    max_val = max(max_val, cnt)
    min_val = min(min_val, cnt)

print(min_val, max_val)