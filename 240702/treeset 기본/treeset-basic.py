from sortedcontainers import SortedSet

n = int(input())
s = SortedSet()      # treeset

for _ in range(n):
    order = input()
    if order.startswith("add"):
        x = int(order.split()[1])
        s.add(x)

    elif order.startswith("remove"):
        x = int(order.split()[1])
        s.remove(x)

    elif order.startswith("find"):
        x = int(order.split()[1])
        print("true" if x in s else "false")

    elif order.startswith("lower_bound"):
        x = int(order.split()[1])
        idx = s.bisect_left(x)
        if idx == len(s):
            print("None")
        else:
            print(s[idx])

    elif order.startswith("upper_bound"):
        x = int(order.split()[1])
        idx = s.bisect_right(x)
        if idx == len(s):
            print("None")
        else:
            print(s[idx])

    elif order.startswith("largest"):
        if len(s) == 0:
            print("None")
        else:
            print(s[-1])

    elif order.startswith("smallest"):
        if len(s) == 0:
            print("None")
        else:
            print(s[0])