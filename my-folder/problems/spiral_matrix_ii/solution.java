class Solution {
    int next = 0;
    void rec(int[][] s, int r, int c){ 
        // if current position is out of bound or cell is visited
        if(r < 0 || r == s.length || c < 0 || c == s[0].length || s[r][c] != 0)
            return;
        
        s[r][c] = ++next;
        
        // move towards right only when you are at the top of spirl matrix or below the filled cell
        if(r == 0 || s[r-1][c] != 0)
            rec(s,r,c+1);
        rec(s,r+1,c);   // moving towards down
        rec(s,r,c-1);   // moving towards left
        rec(s,r-1,c);   // moving towards up

    }
    public int[][] generateMatrix(int n) {
        int sp[][] = new int[n][n];
        rec(sp, 0, 0);
        return sp;
    }
}