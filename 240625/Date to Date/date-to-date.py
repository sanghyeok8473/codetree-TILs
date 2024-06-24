m1, d1, m2, d2 = map(int, input().split())

date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] # 각 월의 날짜를 미리 기록

def numOfDays(m, d):
    returnDate = 0
    for i in range(1, m):
        returnDate += date[i]
    returnDate += d
    return returnDate

print(numOfDays(m2, d2) - numOfDays(m1, d1) + 1)