import sys

INT_MAX = sys.maxsize

# 변수 선언 및 입력:
n, k, b = tuple(map(int, input().split()))
arr = [0] * (n + 1)
prefix_sum = [0] * (n + 1)


# [s, e] 구간 내의 원소의 합을 반환합니다.
def get_sum(s, e):
    return prefix_sum[e] - prefix_sum[s - 1] # s - 1인 이유는, s번째 숫자도 없어져있는 숫자인지 파악하기 위해.


ans = INT_MAX

for _ in range(b):
    x = int(input())
    # 해당 숫자들이 주어진 자리에
    # 숫자 1을 적어줍니다.
    arr[x] = 1

# 누적합 배열을 만들어줍니다.
prefix_sum[0] = 0
for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + arr[i]
    
# prefix의 숫자가 늘어났다는 것은 그 때 있어야할 숫자가 사라졌음을 의미

# 모든 구간에 대해 합을 찾아
# 그 중 최솟값을 갱신합니다.
for i in range(1, n - k + 2):
    ans = min(ans, get_sum(i, i + k - 1))

print(ans)