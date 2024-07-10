n, k = map(int, input().split())

arr = [
    int(input())
    for _ in range(n)
]

R = [-1 for _ in range(n)] # R[x] : 오른쪽에서 R[x]가 나타나는 idx값
last = [-1 for _ in range(1000001)] # last[x] : x가 마지막으로 확인된 값

for i in range(n - 1, 0-1 -1):
    R[i] = last[arr[i]]
    last[arr[i]] = i

ans = -1
for i in range(n):
    if R[i] != 1 and R[i] - i <= k:
        ans = max(ans, arr[i])

print(ans)

"""
ans = -1
for i in range(n):
    for j in range(n):
        if arr[j] in R[i] and i != j:
            ans = max(ans, arr[j])

print(ans)
"""