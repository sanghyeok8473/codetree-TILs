n, m = map(int, input().split())

arr1 = [list(map(int, input().split())) for _ in range(n)]
arr2 = [list(map(int, input().split())) for _ in range(n)]
arr3 = [[1 for _ in range(m)] for _ in range(n)]

for i in range(n):
    for j in range(m):
        if arr1[i][j] == arr2[i][j]:
            arr3[i][j] = 0

for i in range(n):
    for j in range(m):
        print(arr3[i][j], end = " ")
    print()