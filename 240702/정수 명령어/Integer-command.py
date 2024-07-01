from sortedcontainers import SortedSet


t = int(input())

for _ in range(t):
    k = int(input())
    s = SortedSet()
    for _ in range(k):
        order = input()
        if order.startswith("I"):
            n = int(order.split()[1])
            s.add(n)
        else:
            n = int(order.split()[1])
            if not s:
                continue
            if n == 1:
                s.remove(s[-1])
            else:
                s.remove(s[0])
    if not s:
        print("EMPTY")
    else:
        print(s[-1], s[0])