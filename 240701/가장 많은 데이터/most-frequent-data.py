n = int(input())
d = {}

for _ in range(n):
    now = input()
    if now in d:
        d[now] += 1
    else:
        d[now] = 1

max_val = 0

for key in d:
    max_val = max(max_val, d[key])

print(max_val)