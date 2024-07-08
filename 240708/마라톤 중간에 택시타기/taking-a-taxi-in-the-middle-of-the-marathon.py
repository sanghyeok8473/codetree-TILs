n = int(input())

arr = [(0, 0)] + [
    tuple(map(int, input().split()))
    for _ in range(n)
]

L = [0] * (n + 1) # L[x] : 1부터 x까지의 거리
R = [0] * (n + 1) # R[x] : x부터 마지막 까지의 거리

def dist(a, b): # a점과 b점 사이의 거리를 리턴
    return (abs(b[0] - a[0]) + abs(b[1] - a[1]))

for i in range(1, n + 1):
    L[i] = L[i - 1] + dist(arr[i], arr[i - 1])

for i in range(n - 2, 0, -1):
    R[i] = R[i + 1] + dist(arr[i], arr[i + 1])

ans = 100000 * 1000

for i in range(2, n): # 시작점과 마지막 점은 제외
    ans = min(ans, L[i - 1] + R[i + 1] + dist(arr[i - 1] , arr[i + 1]))

print(ans)