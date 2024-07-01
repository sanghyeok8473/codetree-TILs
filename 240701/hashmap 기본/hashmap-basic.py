n = int(input())
d = {}

for _ in range(n):
    now_order = input()
    if now_order[:3] == 'add':
        order, k, v = now_order.split()
        d[k] = v
    elif now_order[:6] == 'remove':
        order, k = now_order.split()
        d.pop(k)
    else:
        order, k = now_order.split()
        if(k in d):
            print(d[k])
        else:
            print("None")