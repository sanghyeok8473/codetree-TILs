from sortedcontainers import SortedSet

n, m = map(int, input().split())

nums = list(map(int, input().split()))

s = SortedSet([(n + 1, 0, n)]) # 수열의 길이, 시작점, 끝점

for num in nums:
    idx = (0, 0, 0)
    for target in s:
        _, x, y = target
        if x >= num and y <= num: # s의 수열 중 num을 포함하는 수열을 찾으면 idx에 수열의 위치를 저장 후 break
            idx = target
            break

    _, x, y = target

    if num == x:
        s.remove(target)   
        s.add((y - num, num + 1, y))
    elif num == y:
        s.remove(target)
        s.add((num - x, x, num - 1))
    else:
        s.remove(target)
        s.add((num - x, x, num -1))
        s.add((y - num, num + 1, y))

    
    print(s[-1][0])