import sys
sys.setrecursionlimit(10000)

ans = sys.maxsize
n = int(input())
edges = [[] for _ in range(n + 1)]
visited  = [False for _ in range(n + 1)]
dist = [0 for _ in range(n + 1)] # dist[x] : dfs한 거리로부터 x번 노드까지의 거리

for _ in range(n-1):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)

# 1부터 n까지의 모든 노드를 dfs한다. dfs할 때마다 dist는 초기화한다. max(dist)의 최소값을 구한다.

def dfs(x):
    for y in edges[x]:
        if not visited[y]:
            visited[y] = True
            dist[y] = dist[x] + 1
            dfs(y)

for i in range(1, n + 1):
    visited  = [False for _ in range(n + 1)]
    dist = [0 for _ in range(n + 1)] # dist[x] : dfs한 거리로부터 x번 노드까지의 거리

    visited[i] = True
    dfs(i)
    ans = min(ans, max(dist))

print(ans)