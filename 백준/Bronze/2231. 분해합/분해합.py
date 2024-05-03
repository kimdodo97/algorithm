def cal_constructor(x):
    result = x
    while(x>0):
        result += x%10
        x = x//10
    return result

n = int(input())

result = 0
for i in range(1,1000000):
    constructor = cal_constructor(i)
    if constructor == n:
        result = i
        break

print(result)
