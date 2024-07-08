from sortedcontainers import SortedSet

n, q = map(int, input().split())

arr = list(map(int, input().split()))
nums = SortedSet(arr)

ab = [list(map(int, input().split())) for _ in range(q)]

for a, b in ab:
    if a < nums[0]:
        print(nums.bisect_right(b) - nums.bisect_right(a))
    else:
        print(nums.bisect_right(b) - nums.bisect_right(a) + 1)