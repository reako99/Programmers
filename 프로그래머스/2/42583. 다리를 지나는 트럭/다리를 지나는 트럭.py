from collections import deque

def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)
    on_bridge = deque([])
    leftTime = deque([])
    time = 0
    while len(truck_weights)>0:
        if sum(on_bridge)+truck_weights[0] <= weight:
            on_bridge.append(truck_weights.popleft())
            leftTime.append(time+bridge_length)
        time+=1
        if leftTime[0]==time:
            leftTime.popleft()
            on_bridge.popleft()    
    return time+bridge_length