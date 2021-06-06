package cn.xiaohupao.leetcode79;

/**
 * @Author: xiaohupao
 * @Date: 2021/6/6 18:11
 */
public class WordSearch {

    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     * @param board an m x n grid of characters board
     * @param word a string word
     * @return true if word exits in the grid
     * time: O()
     * space: O()
     */
    public static boolean exist(char[][] board, String word){
        int m = board.length, n = board[0].length;
        for (int i = 0 ; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int x, int y, String word, int index){
        if (index == word.length()-1){
            return board[x][y] == word.charAt(index);
        }

        char c = board[x][y];
        if ( c != word.charAt(index)){
            return false;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int m = board.length, n = board[0].length;
        board[x][y] = '#';
        for (int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                if (board[nx][ny] == '#'){
                    continue;
                }
                if (dfs(board, nx, ny, word, index+1)){
                    return true;
                }
            }
        }
        board[x][y] = c;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCC";
        System.out.println(exist(board, word));
    }
}
