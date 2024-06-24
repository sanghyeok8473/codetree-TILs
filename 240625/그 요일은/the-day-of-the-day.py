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
now_day = 1 # 시작 요일을 월요일로 고정

for i in range(start, end + 1):
    if(now_day % 7 == a):
        cnt += 1
    now_day = (now_day + 1) % 7

print(cnt)