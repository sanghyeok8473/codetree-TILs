from sortedcontainers import SortedSet

n, q = map(int, input().split())

arr = list(map(int, input().split()))
nums = SortedSet(arr)

mapper = dict()
cnt = 1
for num in nums:
    mapper[num] = cnt
    cnt += 1

ab = [
    list(map(int, input().split()))
    for _ in range(q)
]

for a, b in ab:
    if a > nums[-1] or b < nums[0]:
        print(0)
    else:
        ans = nums.bisect_left(b) - nums.bisect_left(a)

        if a < nums[0] and b in nums or (ans == 0 and b in nums):
            ans += 1


        if a not in nums or b not in nums:
            print(ans)
        else:
            print(ans + 1)