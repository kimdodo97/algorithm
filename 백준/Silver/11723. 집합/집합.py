import sys
n = int(sys.stdin.readline().rstrip())
answer = set()

for _ in range(n) :
    command = sys.stdin.readline().split()
    if len(command)==1 :
        if command[0] == 'all' :
            answer = set([k for k in range(1, 21)])
        else :
            answer = set()
    else :
        cd, value = command[0], int(command[1])
        if cd == 'add' :
            answer.add(value)
        elif cd == 'remove' :
            answer.discard(value)
        elif cd == 'check' :
              print(1 if value in answer else 0)
        elif cd == 'toggle' :
            if value in answer :
                answer.discard(value)
            else :
                answer.add(value)