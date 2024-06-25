n = int(input())
board = [0] * 2001 # n = 100, x = 10, 모든 명령이 L일때 -1000이 이동할 수 있는 최소값이므로 + 1000을 해야함.
# board[x]는 [x, x+1]을 지나간 횟수.
now = 1000

segments = [tuple(input().split()) for _ in range(n)] # 이 때, x는 아직 문자열임.

def printnow():
    for i in range(1000 -11 , 1000 + 2 + 1):
        print(board[i], end = " ")
    print(now)

for x, R in segments:
    x = int(x)
    if(R == 'L'):
        left = now - x
        right = now
        for i in range(left, right):
            board[i] += 1
        now -= x
        
    else:
        left = now
        right = now + x
        for i in range(left, right):
            board[i] += 1
        now += x

cnt = 0

for i in range(2000):
    if board[i] >= 2:
        cnt += 1

print(cnt)



printnow()