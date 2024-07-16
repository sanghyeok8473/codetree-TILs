n, m = map(int, input().split())

spots = [0] + list(map(int, input().split()))

position = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

# x1의 lower_bound x2의 upper_bound의 차이를 구하면 됨
# 양쪽다 소속된 점이면 1을 더해주어야함

for x1, x2 in position:
    left, right, res = 1, n, n + 1
    
    res_cnt = 1 if (x1 in spots and x2 in spots) else 0

    while left <= right:
        mid = (left + right) // 2

        if spots[mid] >= x1:
            res = mid
            right = mid - 1
        else:
            left = mid + 1
    
    result = -res

    left, right, res = 1, n, n + 1

    while left <= right:
        mid = (left + right) // 2

        if spots[mid] > x2:
            res = mid
            right = mid - 1
        else:
            left = mid + 1

    result += (res + res_cnt)

    print(result)