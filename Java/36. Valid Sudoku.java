class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int col = 0;
            int row = 0;

            for (int i2 = 0; i2 < 9; i2++) {
                if (board[i][i2] != '.') {//row
                    int num = board[i][i2] - '0';
                    if ((row & (1 << num)) != 0) {
                        return false;
                    } else {
                        row |= (1 << num);
                    }
                }

                if (board[i2][i] != '.') {//col
                    int num = board[i2][i] - '0';
                    if ((col & (1 << num)) != 0) {
                        return false;
                    } else {
                        col |= (1 << num);
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                int block = 0;

                int colStart = i * 3;
                int colEnd = i * 3 + 3;
                int rowStart = i2 * 3;
                int rowEnd = i2 * 3 + 3;

                for (int i3 = colStart; i3 < colEnd; i3++) {
                    for (int i4 = rowStart; i4 < rowEnd; i4++) {
                        if (board[i3][i4] != '.') {
                            int num = board[i3][i4] - '0';
                            if ((block & (1 << num)) != 0) {
                                return false;
                            } else {
                                block |= (1 << num);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}