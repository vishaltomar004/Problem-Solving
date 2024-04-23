public class Islands {
    
}
class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
      int delR[] = {-1,0,1,0 };
         int delC[] = {0,-1,0,1};
        boolean vis[][]=new boolean[row][col];
      int count=0;
      for(int i =0; i<row; i++)
      {
        for(int j=0; j<col; j++)
        {
            if(vis[i][j]==false && grid[i][j]=='1')
            {
                 count++;
                dfs(vis, grid ,i,j,delR,delC);
               
            }
        }
      }
      return count;
      
    }


    void dfs(boolean vis[][], char grid[][], int row, int col, int delR[], int delC[])
    {
        vis[row][col]=true;
        
        for(int i =0; i<4; i++)
        {
          int newR=row+delR[i];
          int newC=col+delC[i];

          if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && vis[newR][newC]==false && grid[newR][newC]=='1')
          { 
            vis[newR][newC]=true;
            dfs(vis,grid,newR, newC , delR,delC);
            
          }
        }

    }

//     public int numIslands(char[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         int delR[] = {-1,0,1,0 };
//         int delC[] = {0,-1,0,1};
//         boolean vis[][] = new boolean[row][col];
//         int count = 0;
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (vis[i][j] == false && grid[i][j] == '1') {
//                     count++;
//                     dfs(vis, grid, i, j, delR, delC);
//                 }
//             }
//         }
//         return count;
//     }
    
//   void dfs(boolean vis[][], char grid[][], int row, int col, int delR[], int delC[]) {
//     vis[row][col] = true;
//     for (int i = 0; i < 4; i++) {
//         int newR = row + delR[i];
//         int newC = col + delC[i];
//         if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length &&
//             vis[newR][newC] == false && grid[newR][newC] == '1') {
//             dfs(vis, grid, newR, newC, delR, delC);
//         }
//     }
// }


    
    }