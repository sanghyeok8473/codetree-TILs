n, k = map(int, input().split())

arr = [0] + list(map(int, input().split()))

prefix_sum = [0 for _ in range(n + 1)]

for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i]

ans = -100 * 100000 * 100000

# prefix는 같은 숫자가 존재할 수 없다.(주어지는 수의 최소값은 1)

nums = set(prefix_sum)
ans = 0 

for num in nums:
    if (num - k) in nums:
        ans += 1
    
print(ans)