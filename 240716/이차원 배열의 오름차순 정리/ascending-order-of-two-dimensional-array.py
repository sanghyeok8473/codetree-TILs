# 변수 선언 및 입력:
n = int(input())
k = int(input())

left = 1                        # 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
right = n * n                    # 답이 될 수 있는 가장 큰 숫자 값을 설정합니다.
ans = n * n                   # 답을 저장합니다.

while left <= right:               # [lo, hi]가 유효한 구간이면 계속 수행합니다.
    mid = (left + right) // 2      # 가운데 위치를 선택합니다.
    
    val = 0
    for i in range(1, n + 1):
        val += min(n, mid // i)
    
    if val >= k:             # 결정문제에 대한 답이 Yes라면
        right = mid - 1         # 왼쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 hi를 바꿔줍니다.
        ans = min(ans, mid)  # 답의 후보들 중 최솟값을 계속 갱신해줍니다.
    else:
        left = mid + 1         # 결정문제에 대한 답이 No라면 lo를 바꿔줍니다.

# 정답을 출력합니다.
print(ans)