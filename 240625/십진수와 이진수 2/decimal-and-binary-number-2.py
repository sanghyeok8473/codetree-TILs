binary = list(map(int, input()))
n = 0

for i in binary:
    n = n * 2 + i

n *= 17

binary = []

while True:
    if n < 2:
        binary.append(n)
        break;
    binary.append(n % 2)
    n = n // 2

binary.reverse()

for digit in binary:
    print(digit, end='')