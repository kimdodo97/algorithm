import sys

a,b,c,m = map(int,sys.stdin.readline().split())

man_power = 0
result = 0
for i in range(24):
    if (man_power + a) <= m:
        man_power += a
        result += b
    else:
        man_power -= c
        if man_power < 0:
            man_power = 0
print(result)