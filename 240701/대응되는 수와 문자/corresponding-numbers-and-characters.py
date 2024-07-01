n, m = map(int, input().split())
d = {}
reverse_d = {}
max_val = 0

for i in range(1, n + 1):
    now = input()
    d[now] = i
    reverse_d[i] = now

for _ in range(m):
    order = input()
    if order in d:
        print(d[order])
    else:
        print(reverse_d[int(order)])