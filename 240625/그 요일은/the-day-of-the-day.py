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
# 시작 요일을 월요일로 고정해야 하는 이유 : 24.01.01은 월요일이지만, 실제 문제는 그저 윤년인 해의 m1 d1이 월요일일때를 가정. 즉, 시작 요일을 고정해줘야 numOfDays 함수를
# 통해 나온 두 개의 일 수 동안의 요일의 수를 정상적으로 세줄 수 있다.

for i in range(start, end + 1):
    if(now_day % 7 == a):
        cnt += 1
    now_day = (now_day + 1) % 7

print(cnt)