n, m = map(int, input().split())

arr = [0] + list(map(int, input().split()))

for _ in range(m): # left 이상 right 이하
    x = int(input())

    left, right, res = 1, n, -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == x:
            res = mid
            break
        elif arr[mid] < x:
            left = mid + 1
        else:
            right = mid - 1

    print(res)