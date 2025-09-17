# N-Queens-problem-solution-in-Java
You need to place N queens on an N×N chessboard so that:

No two queens attack each other.

That means: no two queens in the same row, same column, or same diagonal.


Return all distinct solutions where each solution is represented as a board with "Q" for queens and "." for empty spaces.


---

🔹 Example

Input: n = 4

Output:

[
  [".Q..",   // One valid placement
   "...Q",
   "Q...",
   "..Q."],

  ["..Q.",   // Another valid placement
   "Q...",
   "...Q",
   ".Q.."]
]


---

🔹 Key Insight

Each row must have exactly one queen.

So, instead of trying every square, we place queens row by row.

At each step, we check:

Is the column free?

Is the diagonal free?




---

🔹 Approach (Backtracking)

1. Start at row 0.


2. Try placing a queen in each column of that row.


3. If the column & diagonals are safe:

Place the queen.

Recurse to the next row.

Backtrack (remove queen) after exploring.



4. Continue until row = n → found a solution.



We track columns, diagonals, and anti-diagonals:

Columns: cols[col]

Diagonal (): diag[row - col]

Anti-diagonal (/): anti[row + col]

