import sys

test_count = int(sys.stdin.readline().rstrip())
for i in range(test_count):
    n = int(sys.stdin.readline().rstrip())
    clothes = {}
    result = 1
    for j in range(n):
        cloth,category = sys.stdin.readline().split()
        if category in clothes:
            clothes[category].append(cloth)
        else:
            clothes[category] = [cloth]

    for value in clothes.values():
        result *= (len(value)+1)

    print(result-1)