# 변수 선언 및 입력
n, k = tuple(map(int, input().split()))
arr = [
    [0 for _ in range(n + 1)]
    for _ in range(n + 1)
]
s = [
    [0 for _ in range(n + 1)]
    for _ in range(n + 1)
]

# 부분합 계산을 원할히 하기 위해 배열을 인덱스 1부터 입력받습니다.
for i in range(n):
    board = list(map(int, input().split()))
    for j in range(n):
        arr[i + 1][j + 1] = board[j]
    
ans = 0

# 배열의 누적합을 구합니다.
for i in range(1, n + 1):
    for j in range(1, n + 1):
        s[i][j] = s[i][j - 1] + arr[i][j]

# 모든 중심에 대해 최댓값을 구합니다.
for i in range(1, n + 1):
    for j in range(1, n + 1):
        # 중심이 (i, j)일 때의 숫자 합을 구합니다.
        sum_all = 0;
        for r in range(i - k, i + k + 1):
            # r행일때 (j - c ~ j + c)열 까지의 부분합을 더해줍니다.
            c = k - abs(i - r);

            # r행이 범위 안에 있을 경우 부분합을 더해줍니다.
            if 1 <= r and r <= n:
                sum_all += s[r][min(j + c, n)] - s[r][max(j - c - 1, 0)]
        
        ans = max(ans, sum_all)

# 정답을 출력합니다.
print(ans)