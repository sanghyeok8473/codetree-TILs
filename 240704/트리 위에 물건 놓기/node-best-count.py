import sys
sys.setrecursionlimit(100000)

n = int(input())

edges = [[] for _ in range(n + 1)]
parent = [0] * (n + 1)
visited = [False for _ in range(n + 1)]
dp = [
    [0, 0]
    for _ in range(n + 1)
]
# dp[x][0] : x에서 색칠하지 않았을 경우
# dp[x][1] : x에서 색칠한 경우

for _ in range(n - 1):
    x, y = map(int, input().split())
    edges[x].append(y)
    edges[y].append(x)

def dfs(x):
    for y in edges[x]:
        if not visited[y]:
            visited[y] = True
            parent[y] = x
            dfs(y)

    dp[x][0] = 0 # 노드에 아무 물건도 놓지 않는 경우
    dp[x][1] = 1 # 노드에 물건은 놓는 경우

    for y in edges[x]:
        if parent[y] == x:
            dp[x][0] += dp[y][1]
            dp[x][1] += min(dp[y][0], dp[y][1])
    

visited[1] = True
dfs(1)

# dp[1][0], dp[1][1] 중 최솟값을 출력합니다.
print(min(dp[1][0], dp[1][1]))