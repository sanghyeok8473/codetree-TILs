OFFSET = 1000 * 1000
a_idx = 1000 * 1000
b_idx = 1000 * 1000

n, m = map(int, input().split())

a_order = [tuple(input().split()) for _ in range(n)]
b_order = [tuple(input().split()) for _ in range(m)]

total_time = 0 # 끝나는 시간
for d, t in a_order:
    t = int(t)
    total_time += t
# 이때 t도 아직 문자열 형태임에 유의
# a의 시간대별 위치와 b의 시간대별 위치를 기록해서, 이 위치가 처음 동일할 때 이를 출력하고 break. 아니면 -1 출력

a = [0] * (OFFSET * 2 + 1)
b = [0] * (OFFSET * 2 + 1)

time = 1
for d, t in a_order:
    t = int(t)
    if d == 'L':
        for i in range(t):
            a_idx -= 1
            a[time] = a_idx
            time += 1
    else:
        for i in range(t):
            a_idx += 1
            a[time] = a_idx
            time += 1

time = 1
for d, t in b_order:
    t = int(t)
    if d == 'L':
        for i in range(t):
            b_idx -= 1
            b[time] = b_idx
            time += 1
    else:
        for i in range(t):
            b_idx += 1
            b[time] = b_idx
            time += 1

for i in range(1, total_time + 1):
    if(a[i] == b[i]):
        print(i)
        break
    if(i == total_time):
        print(-1)