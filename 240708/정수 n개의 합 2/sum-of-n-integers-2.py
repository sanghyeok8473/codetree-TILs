n, k = map(int, input().split())

arr = [0] + list(map(int, input().split()))

prefix_sum = [0 for _ in range(n + 1)]

for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i]

ans = -100 * 100000 * 100000

for i in range(1, n + 1 - k):
    ans = max(ans, prefix_sum[i + k - 1] - prefix_sum[i - 1])
    
print(ans)