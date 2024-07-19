n, m = map(int, input().split())

a = [input() for _ in range(n)]
b = [input() for _ in range(n)]

ans = 0

for i in range(0, m - 2):
    for j in range(i + 1, m - 1):
        for k in range(j + 1, m):
            aSet = set()
            bSet = set()
            for q in range(n):
                aSet.add(a[q][i] + a[q][j] + a[q][k])
                bSet.add(b[q][i] + b[q][j] + b[q][k])
            sep = True
            for el in aSet:
                if el in bSet:
                    sep = False
                    break
            if sep == True:
                ans += 1

# 확실하게 구분할 수 있는 조건 : A에 있는 요소는 B에 존재하면 안된다?
print(ans)