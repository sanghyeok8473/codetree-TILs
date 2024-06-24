digits = list(map(int, input()))

digits.reverse()
result = 0

for i in range(len(digits)):
    result += digits[i]*(2**i)

print(result)