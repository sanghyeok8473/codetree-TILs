n = int(input())

arr = []

for _ in range(n):
    arr.append(int(input()))

maxCnt = 1

for i in range(0, n-1):
    cnt = 0
    if arr[i] > 0:
        for j in range(i, n):
            if arr[j] > 0:
                cnt += 1
            else:
                break
    else:
        for j in range(i, n):
            if arr[j] < 0:
                cnt += 1
            else:
                break
    maxCnt = max(maxCnt, cnt)

print(maxCnt)