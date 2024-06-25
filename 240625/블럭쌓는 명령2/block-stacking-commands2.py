n, k = map(int, input().split())
blocks = [0] * n # 0으로 초기화된 블럭배열 선언

for _ in range(k):
    nowA, nowB = map(int, input().split())
    for i in range(nowA - 1, nowB):
        blocks[i] += 1

print(max(blocks))