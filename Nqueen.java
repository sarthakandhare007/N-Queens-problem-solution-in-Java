import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Fill board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();   // row - col
        Set<Integer> anti = new HashSet<>();   // row + col

        backtrack(0, n, board, results, cols, diag, anti);
        return results;
    }

    private void backtrack(int row, int n, char[][] board,
                           List<List<String>> results,
                           Set<Integer> cols, Set<Integer> diag, Set<Integer> anti) {
        if (row == n) {
            results.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag.contains(row - col) || anti.contains(row + col)) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            cols.add(col);
            diag.add(row - col);
            anti.add(row + col);

            backtrack(row + 1, n, board, results, cols, diag, anti);

            // Backtrack
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row - col);
            anti.remove(row + col);
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    // Quick test
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<String>> solutions = nq.solveNQueens(4);
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
