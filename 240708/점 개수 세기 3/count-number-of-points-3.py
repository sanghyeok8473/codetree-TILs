from sortedcontainers import SortedSet

n, q = map(int, input().split())

arr = list(map(int, input().split()))
nums = SortedSet()
for num in arr:
    nums.add(num)

ab = [list(map(int, input().split())) for _ in range(q)]

for a, b in ab:
    print(nums.bisect_right(b) - nums.bisect_right(a) + 1)