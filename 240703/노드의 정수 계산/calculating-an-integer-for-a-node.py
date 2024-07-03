# Tree
# 1. 사이클 존재 X
# 2. 연결 그래프
# 3. 정점 = 간선 + 1
# 1, 2, 3번 중 두 개를 만족하면 나머지 1개도 만족하게 되므로, 3개 중 두 개만 만족하면 Tree

n = int(input())
visited = [False for _ in range(n + 1)]
edges = [[] for _ in range(n + 1)]
parent = [0 for _ in range(n + 1)]
value  = [0] * (n + 1) # i번 정점의 값
dp = [0] * (n + 1) # dp[i] : i번 정점의 subtree 속한 수의 총합

for i in range(2, n + 1):
    t, a, p = map(int, input().split())
    a = a if t == 1 else -a
    value[i] = a # i번 노드에는 a라는 값이 적혀있다. 
    edges[p].append(i)

def dfs(x):
    # 자기 자신의 값을 누적한다.
    dp[x] = value[x]

    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            parent[y] = x
            dfs(y) # dfs 진행

            dp[x] += dp[y] if dp[y] > 0 else 0

visited[1] = True
dfs(1)

print(dp[1])