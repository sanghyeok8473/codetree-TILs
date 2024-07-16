# 변수 선언 및 입력:
n, tmax = map(int, input().split())

arr = [
    int(input())
    for _ in range(n)
]

left = 1            # k의 최소값
right = n*2 -1 # 답이 될 수 있는 최대값은 n명이므로 첫 mid가 n이 되도록 설정
ans = -1        # 수정되는 최종 정답. 

def is_possible(count): # 한 번에 오를 수 있는 사람들을 정했을 때, 이것이 성립하는지 확인해줌
    # 맨 첫 count개수만큼 만들고, 나머지 부분에서의 max값이 count개가 들어있는 배열의 min값보다 크면 안됨.
    last_idx = count - 1

    on_stage = arr[0:count]

    while last_idx < n - 1:
        now_min = min(on_stage)
        on_stage.remove(now_min)
        on_stage.append(arr[last_idx + 1] + now_min)
        last_idx += 1
    
    return max(on_stage) <= tmax

while left <= right:            
    mid = (left + right) // 2  
    
    if is_possible(mid): # 가능하면 mid가 작아져도 괜찮음
        right = mid - 1
        ans = mid
    else: # 불가능 하다는건 count, 즉 mid가 커져야 한다는 의미임.
        left = mid + 1

# 정답을 출력합니다.
print(ans)