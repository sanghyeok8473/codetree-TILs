n, m = map(int, input().split())

a_order = [tuple(input().split()) for _ in range(n)]
b_order = [tuple(input().split()) for _ in range(m)] 
# 이 때, t는 아직 문자열 형태임.

# a, b의 시간의 각 합을 구해보자.
a_total, b_total = 0, 0

for t, d in a_order:
    t = int(t)
    a_total += t

for t, d in b_order:
    t = int(t)
    b_total += t

max_time = max(a_total, b_total)
# a와 b의 총 시간이 차이날 수 있으니, 더 큰 값을 크기로 가지는 배열로 초기화를 하고, 먼저 끝난 애는 남은 시간동안 그 자리에 있음을 배열로 표시하면 됨.
a_pos = [0] * (max_time + 1)
b_pos = [0] * (max_time + 1)

# a, b 의 위치를 기록
def record(order, pos):
    time = 1
    for t, d in order:
        t = int(t)
        if d == 'L':
            for _ in range(t):
                pos[time] = pos[time - 1] - 1
                time += 1
        else:
            for _ in range(t):
                pos[time] = pos[time - 1] + 1
                time += 1

    if(time < max_time): # a가 b보다 이동시간이 짧으면, 이동을 마친 이후 b가 이동을 마칠 때까지 제자리에 있음을 명시해야함.
        for i in range(time, max_time + 1):
            pos[i] = pos[i - 1]   

record(a_order, a_pos) # a의 위치를 기록
record(b_order, b_pos) # b의 위치를 기록

cnt = 0
for i in range(2, max_time + 1): # 직전까지는 같이 있지 않다가, 같아지는 경우만 세야 하므로 시작 idx는 2(i와 i-1을 체크하기 때문)
    if a_pos[i] == b_pos[i] and a_pos[i-1] != b_pos[i-1]:
        cnt += 1
print(cnt)