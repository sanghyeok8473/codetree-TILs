n, m = map(int, input().split())

arr = [0] + list(map(int, input().split()))

for _ in range(m): # left 이상 right 이하
    x = int(input())

    left, right, min_idx = 1, n, n + 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] >= x:
            min_idx = min(min_idx, mid)
            right = mid - 1
        else:
            left = mid + 1

    left, right, max_idx = 1, n, n + 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] > x:
            max_idx = min(max_idx, mid)
            right = mid - 1
        else:
            left = mid + 1

    result = max_idx - min_idx

    print(result)