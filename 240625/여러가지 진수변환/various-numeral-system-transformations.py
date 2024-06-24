n, b= map(int, input().split())
result = []

if(b == 4):
    while True:
        if(n < 4):
            result.append(n)
            break;
        result.append(n % 4)
        n = n // 4
else:
    while True:
        if(n < 8):
            result.append(n)
            break;
        result.append(n % 8)
        n = n // 8

result.reverse()

for num in result:
    print(num, end='')