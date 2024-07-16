# 변수 선언 및 입력:
n, m = map(int, input().split())

arr = [
    int(input())
    for _ in range(m)
]

# 통과시킬 수 있는 시간을 미리 정하고 성립하는지로 계산

arr.sort() # 정렬

left = 0            # 답이 될 수 있는 최소값 
right = max(arr) * n # 답이 될 수 있는 최대값
ans = 0        # 수정되는 최종 정답. 

def is_possible(x): # x초 안에 모든 통로를 통해 지나갈 수 있는지 확인. 
    cnt = 0
    for num in arr: # x를 각 숫자들로 나눈 몫들의 합을 cnt
        cnt += x // num

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