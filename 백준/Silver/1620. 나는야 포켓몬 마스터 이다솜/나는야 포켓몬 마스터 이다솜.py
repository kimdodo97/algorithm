import sys

n,m = map(int,input().split())
poke = {}
for i in range(1,n+1):
    name = sys.stdin.readline().rstrip()
    poke[name] = str(i)
    poke[str(i)] = name

for i in range(0,m):
    data = sys.stdin.readline().rstrip()
    result = poke[data]
    print(result)