n = int(input())

root = set(range(1, n + 1))
edges = [[] for _ in range(n + 1)]
visited  = [False for _ in range(n + 1)]
arr = list(
    map(int, input().split())
    for _ in range(n - 1)
)
dist = [0] * (n + 1)
not_Tree = False

for x, y, d in arr:
    edges[x].append((y, d))
    edges[y].append((x, d))
    if y in root:
        root.remove(y)

root = root.pop() # 루트노드 구하기

# 루트에서 가장 먼 점을 찾은 다음, 그 점에서 가장 먼 점을 찾으면 그 부분이 정답

def dfs(x, total_dist):
    global farthest_dist, farthest_num

    for y, d in edges[x]:
        if not visited[y]:
            visited[y] = True
            dist[y] = total_dist + d
            if dist[y] > farthest_dist:
                farthest_dist = dist[y]
                farthest_num = y
            dfs(y, total_dist + d)


farthest_num = 0
farthest_dist = -1

visited[1] = True
dfs(1, 0)

farthest_dist = -1
now = farthest_num
farthest_num = 0

visited  = [False for _ in range(n + 1)]

visited[now] = True
dfs(now, 0)

print(farthest_dist)