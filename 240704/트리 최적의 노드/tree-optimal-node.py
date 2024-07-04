import sys
sys.setrecursionlimit(100000)

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
# 이러면 n

def dfs(x):
    global max_dist, last_node

    for y in edges[x]:
        if not visited[y]:
            visited[y] = True
            dist[y] = dist[x] + 1

            if dist[y] > max_dist:
                max_dist = dist[y]
                last_node = y

            dfs(y)

# 지름을 구한다음, (지름+1)/2를 하면 됨.
max_dist = 0
last_node = 0

visited[1] = True
dfs(1)

visited  = [False for _ in range(n + 1)]
dist = [0 for _ in range(n + 1)] # dist[x] : dfs한 거리로부터 x번 노드까지의 거리


visited[last_node] = True
dfs(last_node)

print((max_dist + 1) // 2)