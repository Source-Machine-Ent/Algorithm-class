// 220417
// 프로그래머스 :: 행렬 테두리 회전하기

package wonyoung.etc;

class Main {
    public static void main(String[] args) throws Exception {
        int[][] queries = { {2,2,5,4},{3,3,6,6},{5,1,6,3}};

        Solution s = new Solution();
        s.solution(6, 6, queries);
    }
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // 보드 선언 및 초기화
        int[][] board = new int[rows + 1][columns + 1];
        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                board[r][c] = (r - 1) * columns + c;
            }
        }

        // 쿼리 요소 만큼 실행
        for (int i = 0; i < queries.length; i++) {
            int aRow = queries[i][0];
            int aCol = queries[i][1];
            int bRow = queries[i][2];
            int bCol = queries[i][3];

            int tmp = board[aRow][aCol];
            int min = tmp;

            // a지점 아래부터 하나씩 덮어쓰기
            int currRow = aRow + 1;
            int currCol = aCol;

            // 첫 칸부터
            board[aRow][aCol] = board[currRow][currCol];

            while (true) {
                min = Math.min(min, board[currRow][currCol]);

                // 종료 조건 :: a의 왼쪽칸
                if (currRow == aRow && currCol == aCol + 1) {
                    board[currRow][currCol] = tmp;
                    break;
                }

                // 층은 다르지만 라인이 같을 때
                else if (currCol == aCol) {
                    if (currRow == bRow) {
                        board[currRow][currCol] = board[currRow][currCol + 1];
                        currCol++;
                    } else {
                        board[currRow][currCol] = board[currRow + 1][currCol];
                        currRow++;
                    }
                }

                else if (currCol == bCol) {
                    if (currRow == aRow) {
                        board[currRow][currCol] = board[currRow][currCol - 1];
                        currCol--;
                    } else {
                        board[currRow][currCol] = board[currRow - 1][currCol];
                        currRow--;
                    }
                }

                else if (currRow == bRow) {
                    board[currRow][currCol] = board[currRow][currCol + 1];
                    currCol++;
                }

                else if (currRow == aRow) {
                    board[currRow][currCol] = board[currRow][currCol - 1];
                    currCol--;
                }
            }

            answer[i] = min;
        }
        return answer;
    }
}