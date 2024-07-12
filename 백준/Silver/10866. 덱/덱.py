import sys

answer = []
n = int(sys.stdin.readline())

for _ in range(n):
    data = sys.stdin.readline().split()

    if data[0] == 'push_back':
        answer.append(int(data[1]))
    elif data[0] == 'push_front':
        answer.insert(0, data[1])
    elif data[0] == 'pop_front':
        if len(answer) == 0:
            print(-1)
        else:
            print(answer.pop(0))
    elif data[0] == 'pop_back':
        if len(answer) == 0:
            print(-1)
        else:
            print(answer.pop())
    elif data[0] == 'empty':
        if len(answer) == 0:
            print(1)
        else:
            print(0)
    elif data[0] == 'front':
        if len(answer) == 0:
            print(-1)
        else:
            print(answer[0])
    elif data[0] == 'back':
        if len(answer) == 0:
            print(-1)
        else:
            print(answer[-1])
    elif data[0] == 'size':
        print(len(answer))
