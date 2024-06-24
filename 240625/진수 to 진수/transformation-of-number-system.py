a, b= list(map(int, input().split()))
n = list(map(int, input()))
number = 0

for i in n:
    number = number * a + i

result = []

while True:
    if number < b:
        result.append(number)
        break;
    result.append(number % b)
    number = number // b

result.reverse()

for num in result:
    print(num, end='')