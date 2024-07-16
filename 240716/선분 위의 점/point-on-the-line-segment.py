n, m = map(int, input().split())

spots = [0] + list(map(int, input().split()))

position = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

# x1의 lower_bound x2의 upper_bound의 차이를 구하면 됨

spots.sort()

for x1, x2 in position:
    left, right, lb = 1, n, n + 1

    while left <= right:
        mid = (left + right) // 2

        if spots[mid] >= x1:
            lb = mid
            right = mid - 1
        else:
            left = mid + 1

    left, right, up = 1, n, n + 1

    while left <= right:
        mid = (left + right) // 2

        if spots[mid] > x2:
            up = mid
            right = mid - 1
        else:
            left = mid + 1

    result = up - lb

    print(result)