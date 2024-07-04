n = int(input())

edges = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
dist = [0] * (n + 1) # 시작점부터 x까지의 거리
ans = n - 1

piece = [0] * (n - 1)

arr = [
    tuple(map(int, input().split()))
    for _ in range(n-1)
]

# 리프노드 : edges[x]가 비어있으면 리프노드
# 이 문제는 리프노드들이 루트 노드까지 가는 거리들의 총합을 구한다음, 그 값이 짝수인지 홀수인지 구하면 된다.
# 총합이 홀수이면 1, 총합이 짝수이면 0이다.
# 노드가 3개면, 간선은 2개다.(무조건 간선의 수는 노드-1개)
# 즉, n이 주어지면 간선의 개수를 n-1로 잡고, append 할 때 x가 1이 아니면 간선에서 -1을 해주면(리프노드가 아니게 되므로) 된다.

for x, y in arr:
    if x != 1 and len(edges[x]) == 0: # x가 루트노드가 아니고, 아직 한 번도 나온적이 없어 이전까지 리프노드인 상태였다면
        ans - 1
    edges[x].append(y)

if ans%2 == 0:
    print(0)
else:
    print(1)