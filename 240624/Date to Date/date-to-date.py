m1, d1, m2, d2 = map(int, input().split())

date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] # 각 월의 날짜를 미리 기록

date1 = 0
date2 = 0

for i in range(1, m1):
    date1 += date[i]
date1 += d1

for i in range(1, m2):
    date2 += date[i]
date2 += d2

print(date2 - date1 + 1)