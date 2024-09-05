def solution(lottos, win_nums):
    answer = []
    best = 0
    worst = 0
    for i in range(0,len(lottos)):
        if lottos[i] in win_nums:
            best+=1
            worst += 1
        if lottos[i] == 0:
            best+=1
    answer = [check_win(best),check_win(worst)]
    return answer

def check_win(count):
    if(count == 6):
        return 1
    elif(count==5):
        return 2
    elif(count==4):
        return 3
    elif(count==3):
        return 4
    elif(count==2):
        return 5
    else:
        return 6