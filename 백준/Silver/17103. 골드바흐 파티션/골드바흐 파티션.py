import sys

input = sys.stdin.readline

arr= [True for _ in range(1000001)]

for i in range(2, 1000001):
    j = 2
    if arr[i]:
        while i * j <= 1000000:
            arr[i*j] = False
            j += 1

n = int(input())
for _ in range(n):
    even = int(input())
    answer = 0
    for i in range(2, even//2+1):
        if arr[i] and arr[even-i]:
            answer += 1
    print(answer)
