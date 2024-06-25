n, m, k = map(int, input().split())

arr = []
students = [0] * (n+1)

for _ in range(m):
    arr.append(int(input()))

for i in range(m):
    students[arr[i]] += 1
    if students[arr[i]] >= k:
        print(arr[i])
        break;
    if(i == m-1):
        print(-1)