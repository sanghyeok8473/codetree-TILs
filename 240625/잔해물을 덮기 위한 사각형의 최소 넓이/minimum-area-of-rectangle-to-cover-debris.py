a = list(map(int, input().split())) # [2, 1, 7, 4]
b = list(map(int, input().split())) # [5, -1, 10, 3]

board =[[0] * 2001 for _ in range(2001)]

# B가 A의 일부를 한 줄로 깔끔하게 지운경우는 남은 직사각형의 넓이이고, A가 B에 포함되어 있는 경우에는 0, 아예 겹치지 않는 경우에는 A의 넓이, 나머지는 a의 넓이가 정답
# B가 A의 일부만큼 겹치거나 아예 겹치지 않으면 A의 넓이가 정답, 포합되어있으면 0, 한 줄로 깔끔하게 지우면 남은 부분의 넓이가 정답

if a[0] >= b[0] and a[2] <= b[2] and a[1] >= b[1] and a[3] <= b[3]: # a가 b에 포함된 경우
    print(0)    
elif a[0] >= b[0] and a[2] <= b[2] or a[1] >= b[1] and a[3] <= b[3]: # 가로 한 줄이 깔끔하게 밀리는 경우 또는 세로 한 줄이 깔끔하게 밀리는 경우, 남은 a의 넓이 출력
        cnt = 0
        for i in range(a[0], a[2]):
            for j in range(a[1], a[3]):
                board[i][j] = 1
        for i in range(b[0], b[2]):
            for j in range(b[1], b[3]):
                board[i][j] = 0
        for i in range(2001):
            for j in range(2001):
                cnt += board[i][j]
        print(cnt) 
else: # 일부만 겹치거나 아예 겹치지 않은 경우
    print(((a[2] - a[0]) * (a[3] - a[1]))) # a의 넓이