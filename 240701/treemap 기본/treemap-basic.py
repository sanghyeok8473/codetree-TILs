from sortedcontainers import SortedDict

n = int(input())
sd = SortedDict()      # treemap

for _ in range(n):
    order = input()
    if order.startswith("add"):
        _, k, v = order.split()
        k, v = int(k), int(v)
        sd[k] = v
    elif order.startswith("remove"):
        _, k = order.split()
        k = int(k)
        sd.pop(k)
    elif order.startswith("find"):
        _, k = order.split()
        k = int(k)
        if k in sd:
            print(sd[k])
        else:
            print("None")
    else:
        if not sd:
            print("None")
        else:
            for value in sd.values():
                print(value, end = " ") 
            print()