import heapq


def solution(scoville, K):
    answer = 0
    queue = []
    for i in range(len(scoville)):
        heapq.heappush(queue,(scoville[i]))
    
    while(True):
        curr_sco = heapq.heappop(queue)    
        if(curr_sco >= K):
            return answer

        next_sco = heapq.heappop(queue)
        new_curr = (curr_sco+(next_sco*2))
        answer += 1
        heapq.heappush(queue,new_curr)
        if(len(queue) == 1 and queue[0] < K):
            return -1
    return answer