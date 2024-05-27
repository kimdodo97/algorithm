N = int(input())
tops = [0 for _ in range(1001)]

max_top = 0
max_idx = 0
for i in range(N):
    x,y = map(int, input().split())
    tops[x] = y
    if y > max_top:
        max_top = y
        max_idx = x

top_value = 0
answer = 0
for i in range(max_idx+1):
    top_value = max(top_value,tops[i])
    answer += top_value

top_value = 0
for i in range(1000,max_idx,-1):
    top_value = max(top_value,tops[i])
    answer += top_value

print(answer)