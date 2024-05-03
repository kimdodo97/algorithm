import sys


def cal1(x,y):
    return a*x + b*y

def cal2(x,y):
    return d*x + e*y

a,b,c,d,e,f = map(int,sys.stdin.readline().split())
stop = False
for i in range(-999,1000):
    for j in range(-999, 1000):
        if(cal1(i,j)==c and cal2(i,j)==f):
            print(i,j)
            stop = True
            break
    if stop:
        break