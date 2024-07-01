n, k = map(int, input().split())
d = dict()

ans = 0
nums = list(map(int, input().split()))

for el in nums:
    if el in d:
        d[el] += 1
    else:
        d[el] = 1

# 가능한 숫자 쌍을 찾고, ans는 각 숫자의 키값에 대한 밸류를 곱한 값을 더함.

for i in range(n - 1):
    for j in range(i + 1, n):
        diff = k - nums[i] - nums[j]
        if diff in d:
            ans += d[diff]

print(ans // 3)