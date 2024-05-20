from math import sqrt,gcd
gcd_val,lcm = map(int,input().split())
pred = lcm//gcd_val

min_val = 9999999999999999999
answer = 0
for i in range(1,int(sqrt(pred))+1):
    a = i
    b = pred // a


    if pred%a== 0 and gcd(a,b) == 1:
        if b-a < min_val:
            min_val = b-a
            answer = f"{a*gcd_val} {b*gcd_val}"

print(answer)