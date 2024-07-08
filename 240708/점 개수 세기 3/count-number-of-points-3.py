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
    new_a, new_b = mapper[a], mapper[b]
    print(new_b - new_a + 1)