import sys
from sortedcontainers import SortedSet

INT_MAX = sys.maxsize

# 변수 선언 및 입력:
n, m = tuple(map(int, input().split()))
arr = [
    int(input())
    for _ in range(n)
]

# 입력으로 주어진 숫자를 전부 treeset에 넣어줍니다.
s = SortedSet(arr)

# 답을 저장합니다.
ans = INT_MAX

# 각 숫자 x 대해
# x보다 m 이상 더 크면서 가장 작은 값과
# x보다 m 이상 더 작으면서 가장 큰 값을 구해
# 차이가 가장 작은 경우를 갱신합니다.
for x in arr:
    # x보다 m 이상 더 크면서 가장 작은 값은
    # r >= m + x을 만족하는 최소 r을 구하면 됩니다.
    min_idx = s.bisect_left(m + x)
    if min_idx != len(s): # 전체 숫자 안에 m + x보다 작거나 같은 수가 존재함
        ans = min(ans, s[min_idx] - x)

    # x보다 m 이상 더 작으면서 가장 큰 값은
    # r <= x - m을 만족하는 최대 r을 구하면 됩니다.
    max_idx = s.bisect_right(x - m) - 1 # x - m보다 큰 최초 숫자의 바로 왼쪽에 있는 위치가 >= 0이면, 즉 존재하면
    if max_idx >= 0:
        ans = min(ans, x - s[max_idx])

print(ans if ans != INT_MAX else -1)