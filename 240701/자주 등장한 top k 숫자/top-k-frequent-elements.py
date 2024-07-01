n, k = map(int, input().split())
d = dict()

ans = 0
nums = list(map(int, input().split()))
rank = [0] * k

for el in nums:
    if el in d:
        d[el] += 1
    else:
        d[el] = 1

ans = sorted(d.items(), key = lambda x : (-x[1], -x[0]))

for i in range(k):
    print(ans[i][0] , end = " ")