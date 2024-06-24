a, b, c = map(int, input().split())

day = 24 * 60 # 하루는 24 * 60 = 1440분이다.
hour = 60 # 1시간은 60분이다.

total_minute = (a - 11)*day + (b - 11)*hour + (c - 11)

if(total_minute < 0):
    print(-1)
else:
    print(total_minute)