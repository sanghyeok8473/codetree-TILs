n = int(input())

left = 1
right = 10**9
res = 0

# mid가 왼쪽부터 수를 셌을 때 n번째 수인지 확인하면 됨

def findCnt(x):
    cnt = 0
    for i in range(1, x + 1):
        if i % 3 != 0 and i % 5 != 0:
            cnt += 1
        if cnt > n:
            return False

    return cnt <= n

while left <= right:
    mid = (left + right) // 2

    if findCnt(mid): # cnt가 n미만이면 mid가 커져야 한다는 의미이다.
        res = mid
        left = mid + 1
    else: # 현재 mid값으로는 n을 넘어버림 -> mid가 줄어들어야함. mid가 줄어들으려면 right가 작아져야됨.
        right = mid - 1

print(res)