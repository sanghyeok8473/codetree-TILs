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

cnt = 0
first = 1 if a[1] > b[1] else 2 # 선두를 뜻, a가 선두면 1, b가 선두면 2

for i in range(1, total_time + 1):
    if a[i] > b[i]:
        if(first != 1):
            first = 1
            cnt += 1
    elif a[i] < b[i]:
        if(first != 2):
            first = 2
            cnt += 1

print(cnt)