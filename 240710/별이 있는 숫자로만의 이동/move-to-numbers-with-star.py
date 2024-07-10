# 입력:
n, k = map(int, input().split())

arr = [
    [0] * (n + 1)
    for _ in range(n + 1)
]

for i in range(1, n + 1):
    row = list(map(int, input().split()))
    for j in range(1, n + 1):
        arr[i][j] = row[j - 1]

prefix_sum = [
    [0] * (n + 1)
    for _ in range(n + 1)
]

def in_range(x, y):
    return(1 <= x <= n and 1 <= y <= n)

def get_sum(x, y):
    sum_val = 0
    for i in range(x - k, x + k + 1):
        for j in range(y - k, y + k + 1):
            if in_range(i, j) and (abs(i - x) + abs(j - y) <= k):
                sum_val += arr[i][j]
    return sum_val

max_val = -1
for i in range(1, n + 1):
    for j in range(1, n + 1):
        prefix_sum[i][j] = get_sum(i, j)
        max_val = max(max_val, prefix_sum[i][j])

print(max_val)

"""
prefix[x][y]를 정의하는 방식을 바꿀 수 있다.  x,y에서 거리가 k이내인 점들의 합으로 정의를 하자.

"""