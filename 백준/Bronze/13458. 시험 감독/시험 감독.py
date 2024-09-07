N = int(input())
persons = list(map(int,input().split()))
B,C =list(map(int,input().split()))

answer = 0
for person in persons:
    curr = person - B
    answer += 1
    if(curr>0):
        if(curr%C == 0):
            answer += curr//C
        else:
            answer += (curr//C + 1)
print(answer)
