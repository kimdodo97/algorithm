n = int(input())
friends = []
pos_x = []
pos_y = []
for i in range(n):
    pos = list(map(int,input().split()))
    friends.append(pos)
    pos_x.append(pos[0])
    pos_y.append(pos[1])
answer = [-1] * n

for x in pos_x:
    for y in pos_y:
        sub = []
        for friend in friends:
            sum_dis = abs(x - friend[0]) + abs(y-friend[1])
            sub.append(sum_dis)
        sub.sort()

        result = 0
        for i in range(len(sub)):
            distance = sub[i]
            result += distance
            if answer[i] == -1:
                answer[i] = result
            else:
                answer[i] = min(result,answer[i])

print(' '.join(str(e) for e in answer))
