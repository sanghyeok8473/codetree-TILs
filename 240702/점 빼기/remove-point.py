from sortedcontainers import SortedSet

n, m = map(int, input().split())

spots = [tuple(map(int, input().split())) for _ in range(n)]

question = []

for _ in range(m):
    k = int(input())
    question.append((k, 0))

s = SortedSet(spots)

for i in range(m):
    idx = s.bisect_left(question[i])
    if idx != len(s):
        print(s[idx][0], s[idx][1])
        s.remove(s[idx])
    else:
        print(-1, -1)