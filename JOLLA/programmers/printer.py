from collections import deque

def solution(priorities, location):
    answer = 0
    d = deque([(v, i) for i, v in enumerate(priorities)])
    
    while d:
        # 맨 앞에꺼 빼서 비교 할 예정
        pre_val = d.popleft()
        
        if len(d) != 0:
            if pre_val[0] < max(d)[0]:
                d.append(pre_val)
            else: #J 인쇄
                answer += 1
                if pre_val[1] == location:
                    break
        else:
            answer += 1
            if pre_val[1] == location:
                break
                
    
    return answer