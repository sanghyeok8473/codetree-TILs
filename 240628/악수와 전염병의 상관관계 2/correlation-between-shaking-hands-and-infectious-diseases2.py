n, k, p, T = map(int, input().split())
# n은 개발자 수, k는 전염되는 횟수, p는 첫 감염자, t는 사건 수

inform = [tuple(map(int, input().split())) for _ in range(T)]

inform.sort(key = lambda x : x[0]) # 정보를 일단 시간(각 튜플이 x일때, x[0]를 기준으로) 오름차순으로 정렬한다.

check_infection = [False] * (n + 1) # 감염 여부를 확인해주는 배열
check_infection[p] = True


less_infection = [0] * (n + 1) # 남은 전염 횟수를 기록해두는 배열
less_infection[p] = k # 시작하는 사람은 남은 횟수를 k번으로 가지고 시작

for t, x, y in inform:
    if check_infection[x] and not check_infection[y]: # x만 감염된 사람인 경우
        if less_infection[x] > 0: # x가 감염된 사람이면서 남은 전염 횟수가 있을 때
            check_infection[y] = True # y를 전염시킴
            less_infection[y] = k # 남은 전염횟수 기록
            less_infection[x] -= 1 # x의 남은 전염횟수 감소
    elif not check_infection[x] and check_infection[y]: # y만 감염된 사람인 경우
        if less_infection[y] > 0: # y가 감염된 사람이면서 남은 전염 횟수가 있을 때
            check_infection[x] = True # x를 전염시킴
            less_infection[x] = k # 남은 전염횟수 기록
            less_infection[y] -= 1 # y의 남은 전염횟수 감소
    elif check_infection[x] and check_infection[y]: # x, y 모두 감염자인 경우, 이 때 else를 쓰면 안되는 이유는 둘 다 감염이 안된 경우도 포함해버리기 때문.
        less_infection[x] =  less_infection[x] - 1 if less_infection[x] > 0 else less_infection[x] # x의 남은 전염횟수 감소, 0보다 클때만.
        less_infection[y] =  less_infection[y] - 1 if less_infection[y] > 0 else less_infection[y] # y의 남은 전염횟수 감소, 0보다 클때만.

for infection in check_infection[1:]: # 0번 인덱스는 의미가 없는 인덱스이므로(사람번호는 1부터 시작) 제외하고 확인
    if infection:
        print(1, end = "")
    else:
        print(0, end = "")