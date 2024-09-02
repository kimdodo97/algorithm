def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    n = len(citations)
    max_h = max(citations)
    for h in range(max_h , 0 , -1):
        for i in range(len(citations)):
            if(citations[i] >= h):
                more_h  = i+1
                less_h  = n-more_h
                if(more_h >= h and less_h <= h):
                    answer =h
                    return answer
    return answer