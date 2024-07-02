from sortedcontainers import SortedSet

n = int(input())

question = SortedSet()

for _ in range(n):
    P, L = map(int, input().split())
    question.add((L, P)) # 난이도가 먼저 기준이 되므로 난이도부터 저장

m = int(input())

for _ in range(m):
    order = input()
    if order.startswith("rc"):
        _, x = order.split()
        x = int(x)
        print(question[-1][1] if x == 1 else question[0][1])
    elif order.startswith("ad"): 
        _, p, l = order.split()
        p, l = int(p), int(l)
        question.add((l, p)) # 난이도가 먼저 기준이 되므로 난이도부터 저장
    else: # sv
        _, p, l = order.split()
        p, l = int(p), int(l)
        question.remove((l, p))