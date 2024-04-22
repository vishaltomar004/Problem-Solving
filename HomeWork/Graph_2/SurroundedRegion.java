package HomeWork.Graph_2;

public class SurroundedRegion {

        public void solve(char[][] mat) {
            int n =mat.length;
            int m =mat[0].length;
        
            int vis[][] = new int[n][m]; 

            for(int j = 0 ; j<m;j++) {
               
                if(vis[0][j] == 0 && mat[0][j] == 'O') {
            
                      dfs(0, j, vis, mat);
                }
                
              
                if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                
                        dfs(n-1,j,vis,mat); 
                }
            }
            
            for(int i = 0;i<n;i++) {
                
                if(vis[i][0] == 0 && mat[i][0] == 'O') {
               
                      dfs(i, 0, vis, mat); 
                }
                
                if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                       dfs(i, m-1, vis, mat); 
                }
            }
            
            for(int i = 0;i<n;i++) {
                for(int j= 0 ;j<m;j++) {
                    if(vis[i][j] == 0 && mat[i][j] == 'O') 
                        mat[i][j] = 'X'; 
                }
            }
            
            return;
        }
    
    
          void dfs(int row, int col,int vis[][], char mat[][]) {
            vis[row][col] = 1; 
            int n = mat.length;
            int m = mat[0].length;
            
     
            
                int nrow = row + 1;
                int ncol = col; 
             
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                    dfs(nrow, ncol, vis, mat); 
                }
    
                  nrow = row -1;
                 ncol = col ; 
        
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                    dfs(nrow, ncol, vis, mat); 
                }
                
    
                  nrow = row ;
                 ncol = col +1; 
             
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                    dfs(nrow, ncol, vis, mat); 
                }
    
                 
                   nrow = row ;
                 ncol = col -1; 
           
                if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                    dfs(nrow, ncol, vis, mat); 
                }
            }
        
    }

