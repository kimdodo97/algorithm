import sys
n,m = map(int,sys.stdin.readline().split())

pass_dict = {}
for i in range(n):
    site, pw = sys.stdin.readline().split()
    pass_dict[site] = pw

for i in range(m):
    site = sys.stdin.readline().rstrip()
    print(pass_dict[site])