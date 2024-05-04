import sys

def cycle_bundage(n):
    bun_dage.append(0)
    bun_dage.append(1)
    bun_dage.append(0)
    bun_dage.append(1)

    for i in range(n+1):
        bun_dage.append(0)

    for i in range(n+1):
        bun_dage.append(1)

a= int(sys.stdin.readline().rstrip())
t = int(sys.stdin.readline().rstrip())
result_type = int(sys.stdin.readline().rstrip())

bun_dage = [0,1,0,1,0,0,1,1]
bun,dage = 0,0
cycle = 1
count = 0
result = 0
stop = False
while(1):
    for i in range(count,len(bun_dage)):
        if bun_dage[i] == 0:
            bun += 1
        if bun_dage[i] == 1:
            dage += 1

        if result_type == 0 and bun == t:
            stop = True
            result = count%a
            break
        if result_type == 1 and dage == t:
            stop = True
            result = count%a
            break

        count += 1
    #print(bun_dage)
    if stop:
        print(result)
        break
    cycle += 1
    cycle_bundage(cycle)