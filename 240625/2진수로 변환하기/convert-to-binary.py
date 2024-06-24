n = int(input())

result = []

while n > 0:
    result.append(n % 2)
    n = n // 2

result.reverse()

for num in result:
    print(num, end='')