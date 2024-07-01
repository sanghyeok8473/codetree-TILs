n = int(input())
d = {}
max_val = 0

for _ in range(n):
    now = input()
    if now in d:
        d[now] += 1
    else:
        d[now] = 1
    max_val = max(max_val, d[now])
    
print(max_val)