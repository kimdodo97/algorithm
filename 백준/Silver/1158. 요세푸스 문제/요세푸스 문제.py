n,k = map(int,input().split())

arr = [x for x in range(1,n+1)]
answer = "<"
next = 0
for i in range(n):
    next = next + (k-1)
    next = next % len(arr)
    curr = arr.pop(next)
    if i!=n-1:
        answer = answer + str(curr) + ", "
    else:
        answer = answer + str(curr) + ">"
print(answer)