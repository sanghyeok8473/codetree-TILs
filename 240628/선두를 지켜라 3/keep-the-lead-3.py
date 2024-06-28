OFFSET = 1000 * 1000
n, m = map(int, input().split())

a_order = [tuple(input().split()) for _ in range(n)]
b_order = [tuple(input().split()) for _ in range(m)]

total_time = 0
for v, t in a_order:
    t = int(t)
    total_time += t
# 총 시간 구하기

a = [0] * (OFFSET + 1)
b = [0] * (OFFSET + 1)

# 초마다 위치를 기록해주면 됨.
time, a_pos = 1, 0
for v, t in a_order:
    v, t = int(v), int(t)
    for i in range(t):
        a[time] = a_pos + v
        a_pos += v
        time += 1
time, b_pos = 1, 0
for v, t in b_order:
    v, t = int(v), int(t)
    for i in range(t):
        b[time] = b_pos + v
        b_pos += v
        time += 1

cnt = 1 # 시작할 때, 명예의 전당이 공석에서 무언가로 채워질 것이므로(first에 값이 없다가 1, 2, 3중 하나가 되니까) 1로 시작함.
first = 3 if a[1] == b[1] else (1 if a[1] >= b[1] else 2) # 선두를 뜻, a가 선두면 1, b가 선두면 2, 둘 다 선두면 3

for i in range(1, total_time + 1):
    now = 3 if a[i] == b[i] else (1 if a[i] >= b[i] else 2) # 현재의 선두 상태를 now에 저장
    if first != now:
        first = now
        cnt += 1

print(cnt)