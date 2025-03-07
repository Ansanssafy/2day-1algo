import sys
I = sys.stdin.readline
N, M = map(int, I().split())
arr = [list(map(int, I().split())) for _ in range(N)]

class FindTetromino():
    cnt = 0
    
    def __init__(self):
        self.lst = arr
        # 한 가지
        self.nemo = [
            [(0,1), (1,0), (1,1)]
            ] 
        # 두 가지
        self.ilja = [
            [(0,1), (0,2), (0,3)], 
            [(1,0),(2,0),(3,0)]
            ] 
        # 두 가지
        self.z_shape = [
            [(1,0),(1,1), (2,1)],
            [(0,1), (-1,1), (-1,2)],
            [(-1,0), (-1,1), (-2,1)],
            [(0,1), (1,1), (1,2)]
            ]
        # 네 가지
        self.giyuck = [
            [(1,0), (2,0), (2,1)],    # L 모양
            [(0, -1), (0, -2), (1, -2)],    # 90도 회전
            [(-1,0), (-2,0), (-2,-1)],   # 180도 회전
            [(0,1), (0,2), (-1,2)],    # 270도 회전
            
            [(0, 1), (-1,1), (-2,1)],
            [(1,0), (1,1), (1,2)],
            [(0, -1), (1, -1), (2,-1)],
            [(-1, 0), (-1, -1), (-1,-2)]
            ]
        # 네 가지
        self.foque = [
            [(0,1), (0,2), (-1,1)],   # ㅗ
            [(1,0), (1,1), (2,0)],    # ㅏ
            [(0,-1), (0,-2), (1,-1)], # ㅜ
            [(1,0), (1,-1), (2,0)]    # ㅓ
            ]
        
    def is_within_bounds(self, x, y):
        return 0 <= x < N and 0 <= y < M
    
    def find_max_sum(self):
        max_sum = 0
        tetrominos = [self.nemo, self.ilja, self.z_shape, self.giyuck, self.foque]
        
        for i in range(N):
            for j in range(M):
                for shapes in tetrominos:
                    for shape in shapes:
                        curruent_sum = arr[i][j]
                        for p in shape:
                            if self.is_within_bounds(p[0]+i, p[1]+j):
                                curruent_sum += arr[p[0]+i][p[1]+j]
                            else:
                                break
                        else:
                            max_sum = max(curruent_sum, max_sum)
        return max_sum

a = FindTetromino()
print(a.find_max_sum())