# Tree
# 1. 사이클 존재 X
# 2. 연결 그래프
# 3. 정점 = 간선 + 1
# 1, 2, 3번 중 두 개를 만족하면 나머지 1개도 만족하게 되므로, 3개 중 두 개만 만족하면 Tree

n = int(input())
arr = list(map(int, input().split()))

e = int(input())

visited = [False for _ in range(n)]
edges = [[] for _ in range(n)]
parent = [0 for _ in range(n)] # parent[x] : x의 부모를 뜻함
root = 0

for i, el in enumerate(arr):
    if(el != -1):
        edges[el].append(i)
    else:
        root = i # i번이 root노트 번호이다.

def dfs_erase(x):
    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dfs_erase(y) # dfs 진행

visited[e] = True
dfs_erase(e)

edges[arr[e]].remove(e) # 지울 번호 자체도 지우고

for i, visit in enumerate(visited): # 지울 번호의 자식 노드들도 지우고
    if visit:
        edges[i] = []

ans = 0
visited = [False for _ in range(n)]

def dfs_find(x):
    global ans

    if len(edges[x]) == 0:
        ans += 1

    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dfs_find(y) # dfs 진행

dfs_find(root) # root노드에서 시작해서, 자식이 0인 경우에 ans를 추가
print(ans)