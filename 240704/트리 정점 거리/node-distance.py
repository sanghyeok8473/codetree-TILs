n, m = map(int, input().split())

edges = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
dist = [0] * (n - 1)

arr = [
    tuple(map(int, input().split()))
    for _ in range(n-1)
]

ran = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

for x, y, d in arr:
    edges[x].append((y, d))
    edges[y].append((x, d))

def dfs(x, total_dist): # y에 도착하면 거리를 출력 후 종료
    for y, d in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dist[y] = dist[x] + d
            dfs(y, total_dist + d) # dfs 진행

for s, e in ran:
    dist = [0] * (n + 1)
    visited = [False for _ in range(n + 1)]
    visited[s] = True
    dfs(s, e)
    print(dist[e])