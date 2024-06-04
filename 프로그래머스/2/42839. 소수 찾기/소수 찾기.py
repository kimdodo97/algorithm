import itertools

def solution(numbers):
    answer = 0
    numbers =list(map(int,list(numbers)))
    
    all_numbers = []
    for i in range(1,len(numbers)+1):
        sub_numbers = set(itertools.permutations(numbers,i))
        print(sub_numbers)
        for number in sub_numbers:
            if number[0] == 0:
                continue
            num = int(''.join(map(str, number)))
            result = check(num)
            print(num,result)
            if result is True:
                answer += 1
    return answer

def check(number):
    if number == 1 or number == 0:
        return False
    
    for i in range(2,number):
        if number % i == 0:
            return False
    
    return True