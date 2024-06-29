arr_2d = [list(map(int, input().split())) for _ in range(4)]
ans = 0

for i in range(4):
    for j in range(0, i + 1):
        ans += arr_2d[i][j]
    
print(ans)