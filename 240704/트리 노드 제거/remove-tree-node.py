# 변수 선언 및 입력:
n = int(input())
ans = 0
root = -1
edges = [[] for _ in range(n)]
is_deleted = [False] * (n)

# n개의 간선 정보를 입력받습니다.
par = list(map(int, input().split()))

for i in range(n):
    x, y = i, par[i]

    # -1이 입력된 경우 루트 노드로 지정합니다.
    if y == -1:
        root = x
        continue
    
    # 간선 정보를 인접리스트에 넣어줍니다.
    edges[y].append(x)

# 노드를 제거합니다.
del_node = int(input())


# DFS를 통해 x 아래의 리프노드의 개수를 찾아줍니다.
def dfs(x):
    global ans
    
    # (루트 노드가 삭제되었을 때) 삭제된 노드는 스킵합니다.
    if is_deleted[x]:
        return

    # x번 노드가 리프노드인지 판단합니다. 자신의 자식 노드가
    # 하나라도 남아 있을 경우 x번 노드는 리프노드가 아닙니다.
    is_leaf = True
    for y in edges[x]:
        # 삭제된 노드는 스킵합니다.
        if is_deleted[y]: 
            continue
        dfs(y)

        is_leaf = False

    # 자신 노드가 리프 노드일 경우 답을 갱신합니다.
    if is_leaf: 
        ans += 1

   
# 노드를 제거하는 방법에는 간선을 직접 끊어주는 등 여러 방법이 있습니다.
# 여기서는 삭제되었는지 여부를 배열로 관리합니다.
is_deleted[del_node] = True

# root 정점으로부터 리프노드의 개수를 찾습니다.
dfs(root)

print(ans)

"""
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

def dfs_find(x):
    global ans

    if len(edges[x]) == 0:
        ans += 1

    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dfs_find(y) # dfs 진행

visited[e] = True
dfs_erase(e)

if e != root: # 지울 노드가 루트노드가 아니면
    edges[arr[e]].remove(e) # 지울 번호 자체도 지우고

    for i, visit in enumerate(visited): # 지울 번호의 자식 노드들도 지우고
        if visit:
            edges[i] = []

    ans = 0
    visited = [False for _ in range(n)]

    dfs_find(root) # root노드에서 시작해서, 자식이 0인 경우에 ans를 추가
    print(ans)
else:
    print(0)
"""