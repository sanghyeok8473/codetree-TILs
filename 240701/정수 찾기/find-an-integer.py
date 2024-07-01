n = int(input())
a = list(map(int, input().split()))

m = int(input())
b = list(map(int, input().split()))

set1, set2 = set(a), set(b)

for el in b:
    if el in set1:
        print(1)
    else:
        print(0)