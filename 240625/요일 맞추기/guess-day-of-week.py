m1, d1, m2, d2 = map(int, input().split())

date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] # 각 월의 날짜를 미리 기록
day = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'] # 요일 

def numOfDays(m, d):
    returnDate = 0
    for i in range(1, m):
        returnDate += date[i]
    returnDate += d
    return returnDate

day_diff = numOfDays(m2, d2) - numOfDays(m1, d1)

print(day[day_diff % 7])