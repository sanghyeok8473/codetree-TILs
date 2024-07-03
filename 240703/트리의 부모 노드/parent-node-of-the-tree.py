# Tree
# 1. 사이클 존재 X
# 2. 연결 그래프
# 3. 정점 = 간선 + 1
# 1, 2, 3번 중 두 개를 만족하면 나머지 1개도 만족하게 되므로, 3개 중 두 개만 만족하면 Tree

n = int(input())
visited = [False for _ in range(n + 1)]
edges = [[] for _ in range(n + 1)]
parent = [0 for _ in range(n + 1)]

for _ in range(n - 1):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)

def dfs(x):
    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            parent[y] = x
            dfs(y) # dfs 진행

visited[1] = True
dfs(1)

for i in range(2, n + 1):
    print(parent[i])