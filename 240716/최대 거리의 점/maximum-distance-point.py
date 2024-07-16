import sys

# 변수 선언 및 입력:
n, m = map(int, input().split())

arr = [
    int(input())
    for _ in range(n)
]

# mid가 두 물건 사이의 거리를 가능한 크게 한 값이라고 하면
# n개에서 m개를 픽했을때 안되면 다른 경우도 봐야함

arr.sort() # 정렬

left = 0            # 답이 될 수 있는 최소값 
right = (arr[n - 1] - arr[0]) * 2 - 1     # 첫 mid가 최대 - 최소가 될 수 있는 값으로 시작
ans = 0        # 수정되는 최종 정답. 

def checkAns(x):
    cnt = 1
    last_idx = 0
    for i in range(1, n):
        if arr[i] - arr[last_idx] >= x:
            cnt += 1
            last_idx = i

    return cnt >= m
    

while left <= right:            
    mid = (left + right) // 2  
    
    if checkAns(mid): # mid가 더 커져도 된다는 의미이다. cnt가 m보다 클 수 있기 때문에.
        left = mid + 1
        ans = mid
    else:
        right = mid - 1               

# 정답을 출력합니다.
print(ans)