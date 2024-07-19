n, k = map(int, input().split())

now = dict() # key번 자리에 앉아있는 사람은 value번 사람

seats = [()]
for i in range(1, n + 1):
    seats.append(set([i])) # i번사람이 앉은 자리의 수를 set으로 나타냄.
    now[i] = i

order = []

for _ in range(k):
    a, b = map(int, input().split())
    order.append([a, b])

for i in range(k * 3):
    a, b = order[i % k][0], order[i % k][1]
    temp = now[a]
    now[a] = now[b]
    now[b] = temp

    seats[now[a]].add(a)
    seats[now[b]].add(b)

for i in range(1, n + 1):
    print(len(seats[i]))