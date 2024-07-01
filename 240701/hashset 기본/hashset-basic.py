n = int(input())

hashset = set()

for _ in range(n):
    order = input()
    if order.startswith("add"):
        x = int(order.split()[1])
        hashset.add(x)
    elif order.startswith("find"):
        x = int(order.split()[1])
        if x in hashset:
            print("true")
        else:
            print("false")
    else:
        x = int(order.split()[1])
        hashset.remove(x)