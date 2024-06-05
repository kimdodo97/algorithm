def solution(board):
    answer = 0 
    n = len(board)
    
    moves = [(-1,-1),(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1)]
    result = [[0 for i in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                result[i][j] = -1
                for move in moves:
                    x = i - move[0]
                    y = j - move[1]
                    if x>=0 and y>=0 and x<n and y<n:
                        result[x][y] = -1
                        
    for i in range(n):
        for j in range(n):
            if result[i][j] == 0:
                answer += 1
                
    return answer