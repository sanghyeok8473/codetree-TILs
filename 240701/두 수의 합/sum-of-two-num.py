n, k = map(int, input().split())
d = {}

ans = 0
nums = list(map(int, input().split()))

for i in range(n):
    if nums[i] in d:
        d[nums[i]] += 1
    else:
        d[nums[i]] = 1

for keys in d:
    d[keys] -= 1
    if (k - keys) in d and d[(k - keys)] > 0: # k - key가 존재하면서, k - key의 값이 1개 이상 있어야함.
        d[keys] -= 1
        d[(k - keys)] -= 1
        ans += 1
    d[keys] += 1

print(ans)