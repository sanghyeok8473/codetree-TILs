n, k = map(int, input().split())
d = {}

ans = 0
nums = list(map(int, input().split()))

for i in range(n):
    if nums[i] in d:
        d[nums[i]].append(i + 1)
    else:
        d[nums[i]] = []
        d[nums[i]].append(i + 1)

for key in d:
    if (k - key) in d:
        if k == key * 2:
            ans += len(d[key])*(len(d[key])-1) // 2
        else:
            ans += len(d[key])*len(d[k - key])
print(ans)