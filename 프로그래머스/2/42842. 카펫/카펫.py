def solution(brown, yellow):
    answer = []
    
    x,y = 0,0,
    for i in range(1,yellow+1):
        x,y = 0,0
        cell = 0
        if yellow%i == 0:
            x = i
            y = int(yellow/i)
            if x>=y:
                print(x,y)
                cell = cell + x*2
                cell = cell + y*2
                cell = cell + 4
                print(cell)
                if cell == brown:
                    return [x+2,y+2]
    
    return answer