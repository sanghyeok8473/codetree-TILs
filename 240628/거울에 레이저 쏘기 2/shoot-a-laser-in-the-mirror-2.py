n = int(input())

dxs, dys = [-1, 1, 0, 0], [0, 0, -1, 1] # 상 하 좌 우
# \의 경우, 상<->좌 하<->우로 바뀌고, /의 경우 상<->우 하<->좌로 바뀐다.
#         d = (d + 2) % 4                   d = 3 - d

board = [input() for _ in range(n)]
p = int(input())

# 입력받은 학생번호를 기준으로 시작 좌표와 방향을 설정
if p <= n:
    x = 0
    y = p - 1
    d = 1
elif n < p <= 2 * n:
    x = p - (n + 1)
    y = n - 1
    d = 2
elif 2 * n < p <= 3 * n:
    x = n - 1
    y = 3 * n - p
    d = 0
else:  # 3 * n < p <= 4 * n
    x = 4 * n - p
    y = 0
    d = 3



def inRange(x, y):
    return (0 <= x < n and 0 <= y < n)

def check(nx, ny, d):
    nowCnt = 0
    while inRange(nx, ny):
        if(board[nx][ny] == '/'): # 오른쪽으로 회전
            d = 3 - d
            nx, ny = nx + dxs[d], ny + dys[d]
            nowCnt += 1
        else: # 왼쪽으로 회전
            d = (d + 2) % 4
            nx, ny = nx + dxs[d], ny + dys[d]
            nowCnt += 1
    return nowCnt

print(check(x, y, d))

"""
### 1 ~ 4n번 중 최대로 튕기는 코드
maxCnt = 1 # 아무리 조금 튕겨도, 한 번은 튕김(모서리에 들어가서 바로 나오는 경우)

for j in range(n): # 1, 2...n과 2n + 1, 2n + 2 ... 3n을 처리
    cnt1 = check(0, j, 1)   # (0, 1), (0, 2), ... (0, n)까지 (1, 2, ... n번)의 튕김 횟수 확인
    cnt3 = check(n - 1, j, 0) # (n - 1, 1), (n - 1, 2), ... (n - 1, n)까지 (3n, 3n - 1, ... 2n + 1번)의 튕김 횟수 확인
    maxCnt = max(maxCnt, cnt1, cnt3) # 현재 까지의 최대 튕김 횟수 업데이트

for i in range(n): # n + 1, n + 2...2n과 3n + 1, 3n + 2 ... 4n을 처리
    cnt2 = check(i, n - 1, 2)   # (0, n - 1), (1, n - 1), ... (n - 1, n - 1)까지 (4, 5, ... 2n번)의 튕김 횟수 확인
    cnt4 = check(i, 0, 3) # (0, 0), (1, 0), ... (n - 1, 0)까지 (4n, 4n - 1, ... 3n + 1번)의 튕김 횟수 확인
    maxCnt = max(maxCnt, cnt2, cnt4) # 현재 까지의 최대 튕김 횟수 업데이트

print(maxCnt)
"""