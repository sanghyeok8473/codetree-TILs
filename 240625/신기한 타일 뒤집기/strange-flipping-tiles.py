n = int(input())
board = [0] * (2*(1000* 100) + 1) # 1은 흰색, 2는 검은색, 3은 회색
now = 1000 * 100

segments = [tuple(input().split()) for _ in range(n)] # 이 때, x는 아직 문자열임.

for x, R in segments:
    x = int(x)
    if(R == 'L'): #  흰색으로 칠함
        left = now - x
        right = now
        for i in range(right, left, -1):
            board[i] = 1 # 흰색
        now -= x - 1
    else: # 검은색으로 칠함
        left = now
        right = now + x
        for i in range(left, right):
            board[i] = 2 # 검은색
        now += x - 1
cnt = 0

result = [0, 0] # 각각 흰, 검을 의미
for i in range(2*(1000* 100) + 1):
    if board[i] == 1: # 흰색 일 경우
        result[0] += 1
    elif board[i] == 2: # 검은색일 경우
        result[1] += 1

for col in result:
    print(col, end = " ")