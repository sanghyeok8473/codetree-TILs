a = input()

openNum = 0
ans = 0

for i in range(len(a) - 1):
    if a[i] == '(' and a[i + 1] == '(':
        openNum += 1
    elif a[i] == ')' and a[i + 1] == ')':
        ans += openNum

print(ans)