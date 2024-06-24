n = int(input())

result = []

while True:
    if n < 2:
        result.append(n)
        break

    result.append(n % 2)
    n = n // 2

result.reverse()

for num in result:
    print(num, end='')