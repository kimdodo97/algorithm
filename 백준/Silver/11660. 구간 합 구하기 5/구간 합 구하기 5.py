import sys
input = sys.stdin.readline

N,M = map(int,input().split())

graph = []
for i in range(N):
    datas = list(map(int,input().split()))
    graph.append(datas)

prefix = [[0 for _ in range(N+1)] for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, N+1):
        prefix[i][j] = prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1] + graph[i-1][j-1]


for i in range(M):
    x1,y1,x2,y2 = map(int,input().split())
    a = prefix[x2][y1-1]
    b = prefix[x1-1][y2]
    c = prefix[x1-1][y1-1]

    answer = prefix[x2][y2] - a - b + c
    print(answer)