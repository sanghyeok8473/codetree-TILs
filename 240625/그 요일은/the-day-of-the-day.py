m1, d1, m2, d2 = map(int, input().split())
a = input()

date = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] # 각 월의 날짜를 미리 기록
day = ['', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'] # 요일 

def numOfDays(m, d):
    returnDate = 0
    for i in range(1, m):
        returnDate += date[i]
    returnDate += d
    return returnDate

day_diff = numOfDays(m2, d2) - numOfDays(m1, d1)
cnt = day_diff // 7 ## 일단 이 만큼은 등장했고, 남은 일수동안 요일이 한 번 더 있는지 여부를 확인하면 됨

start = (numOfDays(m1, d1) + cnt*7 - 1) % 7
end = (numOfDays(m2, d2)) % 7
for i in range(start, end+1):
    if(day[i] == a):
        cnt += 1

print(cnt)