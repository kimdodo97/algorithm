import sys
n,k = map(int,sys.stdin.readline().split())
target_k = str(k)
result = 0
for h in range(0,n+1):
    if h//10 == 0:
        h=f"0{h}"
    for m in range(0,60):
        if m//10 == 0:
            m = f"0{m}"
        for s in range(0,60):
            if s//10 == 0:
                s = f"0{s}"
            if f"{k}" in f"{h}{m}{s}":
                result += 1
print(result)