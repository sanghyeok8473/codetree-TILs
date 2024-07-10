a = input()

openStr = []
closeStr = []

for i in range(len(a) - 1):
    if a[i] == '(' and a[i + 1] == '(':
        openStr.append(i)
    elif a[i] == ')' and a[i + 1] == ')':
        closeStr.append(i)

ans = 0

for i in range(len(openStr)):
    for j in range(len(closeStr)):
        if openStr[i] < closeStr[j]:
            ans += 1

print(ans)