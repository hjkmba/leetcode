package tag.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by he.dong on 10/20/2017.
 */
public class _174_DungeonGame {
    int init = -9999999;
    int max = Integer.MAX_VALUE;

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] carry = getInitCarry(dungeon);
        int health = minValueAt(dungeon, carry, 0, 0);
        return health <= 0 ? 1 : health;
    }

    private int[][] getInitCarry(int[][] dungeon) {
        int[][] carry = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < dungeon.length +1 ; i++) {
            for (int j = 0; j < dungeon[0].length+1; j++) {
                carry[i][j] = init;
            }
        }

//        Arrays.fill(carry, init);
        return carry;
    }

    private int minValueAt(int[][] dungeon, int[][] carry, int row, int col) {
        if (carry[row][col] != init)
            return carry[row][col];
        if (row >= dungeon.length || col >= dungeon[0].length){
            carry[row][col] = max;
            return max;
        }
        if (row == dungeon.length - 1 && col == dungeon[0].length - 1) {
            if (dungeon[row][col] >= 0) {
                carry[row][col] = 1;
            } else {
                carry[row][col] = Math.abs(1 - dungeon[row][col]);
            }
            return carry[row][col];
        } else {
            int right = minValueAt(dungeon, carry, row + 1, col) < 0 ? 1 : minValueAt(dungeon, carry, row + 1, col);
            int down = minValueAt(dungeon, carry, row, col + 1) < 0 ? 1 : minValueAt(dungeon, carry, row, col + 1);
            int health = Math.min(right, down) - dungeon[row][col];
            carry[row][col] = health <= 0 ? 1 : health;

            return health;
        }
    }

    public int calculateMinimumHPByLoop(int[][] dungeon) {
        int[][] carry = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i <dungeon.length+1 ; i++) {
            carry[i][dungeon[0].length] = 9999999;
        }
        for (int i=0; i<dungeon[0].length+1; i++){
            carry[dungeon.length][i] = 9999999;
        }
        for (int i = dungeon.length-1; i >=0 ; i--) {
            for (int j = dungeon[0].length-1; j >=0 ; j--) {
                if (i == dungeon.length-1 && j == dungeon[0].length-1) {
                    carry[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
                    continue;
                }
                int val = Math.min(carry[i + 1][j], carry[i][j + 1]) - dungeon[i][j];
                if (val <= 0)
                    carry[i][j] = 1;
                else
                    carry[i][j] = val;
            }
        }
        return carry[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new _174_DungeonGame().calculateMinimumHPByLoop(new int[][]{{0,1,2},{0,3,4},{1,3,4}}));
        System.out.println(new _174_DungeonGame().calculateMinimumHPByLoop(new int[][]{{0,1,2},{0,3,4},{1,3,4}}));
    }

}
