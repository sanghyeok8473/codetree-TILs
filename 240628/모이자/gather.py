n = int(input())
A = list(map(int, input().split()))

minCnt = 100 * 100

for i in range(len(A)):
    nowCnt = 0
    for j in range(len(A)):
        nowCnt += abs(j - i) * A[j]
    minCnt = min(minCnt, nowCnt)

print(minCnt)