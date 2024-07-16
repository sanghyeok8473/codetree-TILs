# 변수 선언 및 입력:
n, m = map(int, input().split())

arr = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

# 점들 사이 거리의 최대값을 미리 정하고 이것이 성립하는지를 계산

arr.sort() # 정렬. a를 기준으로 정렬한 다음 b를 기준으로 정렬될 것임.

left = 0            # 답이 될 수 있는 최소값 
right = 10**18 # 답이 될 수 있는 최대값
ans = -1        # 수정되는 최종 정답. 

def is_possible(x): # 점들 사이 거리의 최대값이 x일때 이것이 가능한지 리턴해주는 함수
    cnt = 0
    last_num = arr[0][0]
    for a, b in arr: # x를 각 숫자들로 나눈 몫들의 합을 cnt
        if a - last_num >= x:
            cnt += 1
            last_num = a
        elif b - last_num >= x:
            cnt += 1
            last_num = b

    return cnt >= n

while left <= right:            
    mid = (left + right) // 2  
    
    if is_possible(mid): # mid가 더 작아져 된다는 의미이다.
        right = mid - 1 
        ans = mid
    else:
        left = mid + 1             

# 정답을 출력합니다.
print(ans)