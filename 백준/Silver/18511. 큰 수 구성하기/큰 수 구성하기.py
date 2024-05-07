import sys
import itertools

N,M = map(int,sys.stdin.readline().split())
repeat_count = len(str(N))
K = set(map(int,sys.stdin.readline().split()))
sub_result = []
for i in range(1,repeat_count+1):
    sub_result.extend(list(itertools.product(K,repeat=i)))
sub_result.reverse()

max = -9999999999999
for value in sub_result:
    int_value = int(''.join(str(e) for e in value))
    if N >= int_value and int_value >= max:
        max = int_value
print(max)