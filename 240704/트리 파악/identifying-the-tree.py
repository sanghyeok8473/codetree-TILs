n = int(input())

edges = [[] for _ in range(n + 1)]
visited = [False for _ in range(n + 1)]
dist = [0] * (n + 1) # 시작점부터 x까지의 거리
ans = 0
is_Leaf = [True for _ in range(n + 1)]

piece = [0] * (n - 1)

arr = [
    tuple(map(int, input().split()))
    for _ in range(n-1)
]

# 리프노드 : edges[x]가 비어있으면 리프노드, 즉 2 ~ n의 숫자들 중 arr의 x에서 등장하지 않은 수
# 이 문제는 리프노드들이 루트 노드까지 가는 거리들의 총합을 구한다음, 그 값이 짝수인지 홀수인지 구하면 된다.
# 총합이 홀수이면 1, 총합이 짝수이면 0이다.
# 노드가 3개면, 간선은 2개다.(무조건 간선의 수는 노드-1개)

for x, y in arr:
    edges[x].append(y)
    is_Leaf[x] = False
    

def dfs(x): # y에 도착하면 거리를 출력 후 종료
    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dist[y] = dist[x] + 1
            dfs(y) # dfs 진행

visited[1] = True
dfs(1)

# dfs를 루트노드에서 한 번 진행하면 특정 노드부터 루트노드까지의 길이가 기록됨. 이후에는 리프노드의 dist만 전부 더해서 짝홀 여부 판단

for i in range(2, n + 1):
    if is_Leaf[i]:
        ans += dist[i]

print(ans)

if ans % 2 == 0:
    print(0)
else:
    print(1)