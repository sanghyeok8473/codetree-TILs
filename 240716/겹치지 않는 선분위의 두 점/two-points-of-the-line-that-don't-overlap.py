# 변수 선언 및 입력:
n, m = map(int, input().split())

arr = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

# 점들 사이 거리의 최대값을 미리 정하고 이것이 성립하는지를 계산

arr.sort() # 정렬. a를 기준으로 정렬한 다음 b를 기준으로 정렬될 것임.

left = 0            # 답이 될 수 있는 최소값은 길이이므로 0
right = arr[m - 1][1] - arr[0][0] # 답이 될 수 있는 최대값은 최대값 - 최소값
ans = -1        # 수정되는 최종 정답. 

def is_possible(x): # 점들 사이 거리의 최대값이 x일때 이것이 가능한지 리턴해주는 함수
    cnt = 0
    last_num = arr[0][0] - x # 정렬되어 있으므로 젤 첫번째 점의 a좌표로 시작하는 것이 좋다.

    for a, b in arr:
        a = max(a, last_num + x) # 시작점을 어디로 잡을지 정해줌

        if a > b: # 여기에는 점을 놓을 수 없음
            continue
        elif a == b: # 여기에 점을 놓고 가면 됨.
            cnt += 1
            last_num = a
        else:
            spots = (b - a) // x + 1
            cnt += spots
            last_num = a + (x * (spots - 1))
            
    return cnt >= n


while left <= right:            
    mid = (left + right) // 2  
    
    if is_possible(mid): # mid가 더 커져야 된다는 의미이다. n이 여유가 있을 필요는 없으므로
        left = mid + 1
        ans = mid
    else: # 점의 개수가 충족이 안된다는 의미이므로 mid 가 더 작아져야 한다는 뜻이다.
        right = mid - 1      

# 정답을 출력합니다.
print(ans)