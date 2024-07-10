n, k = map(int, input().split())

arr = [
    int(input())
    for _ in range(n)
]

R = [{-1} for _ in range(n + 1)] # R[x] : x번지에서 터질 수 있는 폭탄들의 번호들
ans = - 1

for i in range(n):
    for j in range(i - k, i + k + 1):
        if 0 <= j < n and i != j and arr[j] == arr[i]:
            R[j].add(arr[i])
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