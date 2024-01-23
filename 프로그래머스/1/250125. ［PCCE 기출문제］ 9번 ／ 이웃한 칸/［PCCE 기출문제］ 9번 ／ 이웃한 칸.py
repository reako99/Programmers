def solution(board, h, w):
    count = 0
    neighbor = [[1,0],[-1,0],[0,1],[0,-1]]
    for x,y in neighbor:
        if y == 0 :
            if h + x < len(board) and h + x >= 0:
                if board[h+x][w]==board[h][w]:
                    count+=1
        if x == 0 :
            if w + y < len(board) and w + y >= 0:
                if board[h][w+y]==board[h][w]:
                    count+=1
    return count