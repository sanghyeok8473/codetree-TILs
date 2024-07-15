n, m = map(int, input().split())

arr = [
    int(input())
    for _ in range(n)
]

left = 1
right = max(arr)
res = 0

def findMax(x):
    sum_val = 0
    for el in arr:
        sum_val += (el // x)

    return sum_val >= m

while left <= right:
    mid = (left + right) // 2

    if findMax(mid): # m이상이면 m개를 만들 수 있다는 의미이다. mid를 키워도 된다. mid를 키우려면 left가 옮겨져야됨.
        res = mid
        left = mid + 1
    else: # 현재 mid값으로는 m개가 안나옴 -> mid가 줄어들어야함. mid가 줄어들으려면 right가 작아져야됨.
        right = mid - 1

print(res)