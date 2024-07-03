from sortedcontainers import SortedSet

# 변수 선언 및 입력:
n, m = tuple(map(int, input().split()))
arr = list(map(int, input().split()))
s_num = SortedSet()
s_len = SortedSet()

# s_num : 지워진 숫자 모음(코드의 깔끔한 처리를 위해
# 범위 밖의 숫자를 treeset에 추가했습니다)
s_num.add(-1)
s_num.add(n + 1)
# s_len : (-구간의 길이, 시작 숫자, 끝 숫자)
# 길이가 긴 구간부터 나오도록 구간의 길이에 -를 붙여서 넣어줍니다.
s_len.add((-(n + 1), -1, n + 1))

for y in arr:
    # 입력받은 숫자를 treeset에 추가합니다.
    s_num.add(y)

    # 입력받은 숫자 y를 기준으로
    # 그 바로 뒤의 숫자를 z, 바로 앞의 숫자를 x라고 두었습니다.
    z = s_num[s_num.bisect_right(y)]
    x = s_num[s_num.bisect_left(y) - 1]
    
    # 구간의 길이는 (x ~ z) 구간이 사라지며,
    # (x ~ y) 구간과 (y ~ z) 구간이 새로 생겨납니다.
    s_len.remove((
        -(z - x - 1), x, z
    ))
    s_len.add((
        -(y - x - 1), x, y
    ))
    s_len.add((
        -(z - y - 1), y, z
    ))

    # y가 추가된 후로 구간 중 가장 긴 구간을 찾아 출력합니다.
    best_length, _, _ = s_len[0]
    print(-best_length)