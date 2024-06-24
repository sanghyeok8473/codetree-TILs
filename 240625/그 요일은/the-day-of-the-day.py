m1, d1, m2, d2 = map(int, input().split())
a = input()

date = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] # 각 월의 날짜를 미리 기록
day = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'] # 요일, 1월 1일이 월요일이므로 Mon의 인덱스는 1
a = day.index(a) # 입력받은 요일을 day의 인덱스로 바꾸기(Mon이면 0, Sat이면 5)

def numOfDays(m, d):
    returnDate = 0
    for i in range(1, m):
        returnDate += date[i]
    returnDate += d
    return returnDate

start = numOfDays(m1, d1)
end = numOfDays(m2, d2)
cnt = 0

for i in range(start, end + 1):
    if(i % 7 == a):
        cnt += 1
"""
day_diff = numOfDays(m2, d2) - numOfDays(m1, d1)
cnt = day_diff // 7 ## 일단 이 만큼은 등장했고, 남은 일수동안 요일이 한 번 더 있는지 여부를 확인하면 됨

end = (numOfDays(m2, d2)) % 7
if end == 0:
    cnt += 1
elif 1 <= a <= end:
    cnt += 1
"""

print(cnt)