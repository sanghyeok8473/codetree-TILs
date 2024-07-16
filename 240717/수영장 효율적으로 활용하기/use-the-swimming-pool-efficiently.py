n, m = map(int, input().split())

arr = list(map(int, input().split()))

left = 1 # 최소 이용시간의 합
right = sum(arr) # 최대 이용시간의 합
ans = -1

def is_possible(time):
    cnt = 1
    now = arr[0]

    for i in range(1, n):
        if arr[i] + now > time: # 만약 현재 사람이 레일에 들어가면 시간이 넘어버리면
            cnt += 1
            now = arr[i]
        else:
            now += arr[i]

        if cnt > m: # m개의 레일로는 모자라면 더 이상 볼 필요가 없음
            return False

    return cnt <= m

while left <= right:
    mid = (left + right) // 2

    if is_possible(mid): # m개의 레일로 현재 충분한 상황, mid를 더 줄여봐도 됨
        ans = mid
        right = mid - 1
    else: # False라는건 레일이 모자라다는 소리이므로 mid를 키우면 됨
        left = mid + 1

print(ans)