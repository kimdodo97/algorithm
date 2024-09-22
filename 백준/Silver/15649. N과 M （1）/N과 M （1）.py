def recursive(num):
    if num == m:
        print(' '.join(arr))
        return

    for i in range(1,n+1):
        if str(i) in arr:
            continue

        arr.append(str(i))
        recursive(num + 1)
        arr.pop()

n,m = map(int,input().split())
arr = []
recursive(0)
