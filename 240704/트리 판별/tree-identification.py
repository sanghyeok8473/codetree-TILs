# 트리인 것처럼 입력받고, dfs후 visited가 모두 true이면(0번 인덱스 제외) true. 트리인 경우, 어디서 시작해도 모든 정점을 거칠 수 있다.

m = int(input())
arr = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

not_Tree = False

visited = [False for _ in range(10001)]
edges = [[] for _ in range(10001)]
numbers = set() # 등장한 노드 번호들을 저장해줄 배열, 중복은 허용하지 않으므로 set으로 설정

for _, b in arr:
    if b in numbers:
        not_Tree = True # 들어오는 간선이 1개가 아닌 노드가 존재하면 트리가 아님
    numbers.add(b)

# a에서 b로 간다는 거니까 a->b
for a, b in arr:
    edges[a].append(b) # a -> b가 존재한다.
    numbers.add(a)

find_root = set()

for num in numbers:
    find_root.add(num)

for a, b in arr:
    if b in find_root:
        find_root.remove(b)

root = 0

if len(find_root) != 1: # 루트 노드(즉, 들어오는 노드가 없는 노드가 1개가 아니면)가 1개가 아니면 트리가 아님
    not_Tree = True
else:
    root = find_root.pop()

# 루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재해야 한다. : arr의 b가 numbers에 이미 있는지의 여부로 확인 가능
# 여기서 루트를 찾는다. 만약 numbers에서 b에 있는 모든 숫자를 제거했는데 남은 숫자가 없거나 2개 이상이면, 여기서 성립이 안된다.
# 남은 숫자가 하나면 그 숫자가 루트노드의 번호이다.  그 루트를 dfs했을 때, numbers에 있는 모든 노드번호가 visited[]에서 True이면, 이거는 트리가 맞다.


def dfs(x):
    for y in edges[x]:
        if not visited[y]: # y를 아직 방문한적이 없으면, x가 y의 부모이다.
            visited[y] = True
            dfs(y) # dfs 진행

visited[root] = True
dfs(root)

if not_Tree:
    print(0)
else:
    for num in numbers:
        if not visited[num]: # 루트 노드로 판된되는 노드에서 dfs를 했는데 방문하지 못한 곳이 있으면, 트리가 아님
            print(0)
            break
    print(1)