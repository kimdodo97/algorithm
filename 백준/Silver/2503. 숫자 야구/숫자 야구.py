import itertools
import sys

def cal_baseball(expect:int,indata:tuple):
    first = expect // 100
    second = expect % 100 // 10
    third = expect % 10

    expect_data = [first,second,third]
    strike=0
    ball = 0
    for i in range(len(expect_data)):
        for j in range(len(indata)):
            if i==j and expect_data[i]==indata[j]:
                strike+=1
            elif i!=j and expect_data[i]==indata[j]:
                ball += 1

    return strike,ball

n = int(input())
numbers = [1,2,3,4,5,6,7,8,9]
all = list(itertools.permutations(numbers,3))
result = []

rm_list =[]
for i in range(n):
    rm_cnt = 0
    number,s,b = map(int,sys.stdin.readline().split())
    for i in range(len(all)):
        i -= rm_cnt
        strike,ball = cal_baseball(number,all[i])
        if strike!=s or ball != b :
           all.remove(all[i])
           rm_cnt += 1

print(len(all))