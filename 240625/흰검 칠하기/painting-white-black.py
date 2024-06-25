n = int(input())
board = [0] * (2*(1000* 100) + 1) # 1은 흰색, 2는 검은색, 3은 회색
color = [[0, 0] for _ in range(2*(1000* 100) + 1)]  # 흰, 검이 칠해진 횟수를 의미
# board[x]는 [x, x+1]을 지나간 횟수.
now = 1000 * 100

segments = [tuple(input().split()) for _ in range(n)] # 이 때, x는 아직 문자열임.

for x, R in segments:
    x = int(x)
    if(R == 'L'): #  흰색으로 칠함
        left = now - x
        right = now
        for i in range(right, left, -1):
            color[i][0] += 1 # 흰색 칠한 횟수 추가
            if color[i][0] >= 2 and color[i][1] >= 2:
                board[i] = 3 # 회색
            else:
                board[i] = 1 # 흰색
        now -= x - 1
    else: # 검은색으로 칠함
        left = now
        right = now + x
        for i in range(left, right):
            color[i][1] += 1 # 검은색 칠한 횟수 추가
            if color[i][0] >= 2 and color[i][1] >= 2:
                board[i] = 3 # 회색
            else:
                board[i] = 2 # 검은색
        now += x - 1
cnt = 0

result = [0, 0, 0] # 각각 흰, 검, 회를 의미
for i in range(2*(1000* 100) + 1):
    if board[i] == 1: # 흰 일 경우
        result[0] += 1
    elif board[i] == 2: # 검은색일 경우
        result[1] += 1
    elif board[i] == 3: # 회색일 경우
        result[2] += 1

for col in result:
    print(col, end = " ")