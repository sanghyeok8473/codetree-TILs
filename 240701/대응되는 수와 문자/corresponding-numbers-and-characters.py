n, m = map(int, input().split())
d = {}
max_val = 0

for i in range(1, n + 1):
    now = input()
    d[now] = i

for _ in range(m):
    order = input()
    if order in d:
        print(d[order])
    else:
        print(list(d.keys())[int(order) - 1])