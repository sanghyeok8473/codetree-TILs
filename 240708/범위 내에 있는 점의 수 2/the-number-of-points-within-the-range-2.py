from sortedcontainers import SortedSet

# 변수 선언 및 입력:
n, q = map(int, input().split())
arr = list(map(int, input().split()))

nums = SortedSet(arr)

seq = [
    tuple(map(int, input().split()))
    for _ in range(q)
]

for x, y in seq:
    left = nums.bisect_left(x)
    right = nums.bisect_left(y)
    if x not in nums or y not in nums:
        print(right - left)
    else:
        print(right - left + 1)