n, m = map(int, input().split())

nums = [0] + list(map(int, input().split()))

questions = list(map(int, input().split()))

for q in questions:
    left, right, res = 1, n, -1

    while left <= right:
        mid = (left + right) // 2

        if nums[mid] >= q:
            res = mid
            right = mid - 1
        else:
            left = mid + 1

    if(nums[res] == q):
        print(res)
    else:
        print(-1)