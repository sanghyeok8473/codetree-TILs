n, k = map(int, input().split())
d = {}

ans = 0
nums = list(map(int, input().split()))

for i in range(n):
    d[i + 1] = nums[i] # d[위치] = 값

for key1 in d:
    for key2 in d:
        if k - d[key1] == d[key2] and key1 != key2:
            ans += 1
    

print(ans // 2)