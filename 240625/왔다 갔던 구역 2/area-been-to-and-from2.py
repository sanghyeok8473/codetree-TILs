n = int(input())
board = [0] * 2001 # n = 100, x = 10, 모든 명령이 L일때 -1000이 이동할 수 있는 최소값이므로 + 1000을 해야함.
now = 1000

segments = [tuple(input().split()) for _ in range(n)] # 이 때, x는 아직 문자열임.

for x, R in segments:
    if(R == 'L'):
        for i in range(now, now - int(x) - 1, - 1):
            board[i] += 1
        now -= int(x)
    else:
        for i in range(now, now + int(x) + 1):
            board[i] += 1
        now += int(x)

cnt = 0
k = 0

while k < 2001:
    if board[k] >= 2:
        now = []
        for j in range(k, 2001):
            if board[j] < 2:
                cnt += len(now) - 1
                k = j - 1
                break
            now.append(board[j])
    k += 1

print(cnt)
# print(now - 1000)