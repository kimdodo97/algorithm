n = int(input())
for i in range(n):
    password = int(input())
    cnt = 2
    result = 'YES'
    while(cnt<1000001):
        if password%cnt == 0:
            result = 'NO'
            break
        cnt += 1
    print(result)