from sortedcontainers import SortedSet

n, q = map(int, input().split())

arr = list(map(int, input().split()))
ab = [tuple(map(int, input().split())) for _ in range(q)]

nums = SortedSet(arr)

mapper = dict()
cnt = 1
for num in nums:
    mapper[num] = cnt
    cnt += 1

for a, b in ab:
    new_a = nums.bisect_right(a)
    new_b = nums.bisect_right(b) if b < nums[-1] else n - 1
    print(new_b - new_a + 1)

"""
for a, b in ab:
    if a < nums[0]:
        print(nums.bisect_right(b) - nums.bisect_right(a))
    else:
        print(nums.bisect_right(b) - nums.bisect_right(a) + 1)
"""