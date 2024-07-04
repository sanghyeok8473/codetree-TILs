n = int(input())

edges = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
dist = [0] * (n + 1) # 시작점부터 x까지의 거리
ans = 0

piece = [0] * (n - 1)

arr = [
    tuple(map(int, input().split()))
    for _ in range(n-1)
]

# 리프노드 : edges[x]가 비어있으면 리프노드
# 이 문제는 리프노드들이 루트 노드까지 가는 거리들의 총합을 구한다음, 그 값이 짝수인지 홀수인지 구하면 된다.
# 총합이 홀수이면 1, 총합이 짝수이면 0이다.

for x, y in arr:
    edges[x].append(y)

def dfs(x, total_dist): # y에 도착하면 거리를 출력 후 종료
    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dist[y] = dist[x] + 1
            dfs(y, total_dist + 1) # dfs 진행

for i in range(1, n + 1):
    if len(edges[i]) > 0:
        continue
    else: # edges[i]는 리프노드이다.
        dist = [0] * (n + 1)
        visited = [False for _ in range(n + 1)]
        visited[1] = True
        dfs(1, 0)
        ans += dist[i]

if ans%2 == 0:
    print(0)
else:
    print(1)