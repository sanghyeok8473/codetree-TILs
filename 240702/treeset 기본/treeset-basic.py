from sortedcontainers import SortedSet

n = int(input())
s = SortedSet()      # treeset

for _ in range(n):
    order = input()
    if order.startswith("add"):
        x = order.split()[1]
        if x not in s:
            s.add(x)
    elif order.startswith("remove"):
        x = order.split()[1]
        if x in s:
            s.remove(x)
    elif order.startswith("find"):
        x = order.split()[1]
        if x in s:
            print("true")
        else:
            print("false")
    elif order.startswith("lower_bound"):
        x = order.split()[1]
        idx = s.bisect_left(x)
        if idx == len(s):
            print("None")
        else:
            print(s[idx])
    elif order.startswith("upper_bound"):
        x = order.split()[1]
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