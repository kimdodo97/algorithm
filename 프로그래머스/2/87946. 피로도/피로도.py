import itertools

def solution(k, dungeons):
    answer = -1
    
    pers = list(itertools.permutations(dungeons,len(dungeons)))
    for per in pers:
        curr_k = k
        sub_result = 0
        for dungeon in per:
            if curr_k >= dungeon[0]:
                curr_k -= dungeon[1]
                sub_result += 1
        if sub_result > answer:
            answer = sub_result
    return answer