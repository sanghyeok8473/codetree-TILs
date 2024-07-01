from sortedcontainers import SortedDict

n = int(input())
arr = list(map(int, input().split()))
sd = SortedDict()      # treemap

for i in range(1, n + 1):
    if arr[i-1] not in sd:
        sd[arr[i-1]] = i

for key, value in sd.items():
    print(key, value)