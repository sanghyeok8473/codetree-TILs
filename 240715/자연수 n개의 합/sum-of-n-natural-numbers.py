s = int(input())

left = 1
right = s
res = 0

while left <= right:
    mid = (left + right) // 2

    if (mid * (mid + 1)) // 2 <= s: # mid보다 더 큰 숫자에서 합이 s이하일 수 있음 -> left를 옮김
        res = mid
        left = mid + 1
    else: # mid에서 총합이 s보다 큼 -> right을 옮김
        right = mid - 1

print(res)