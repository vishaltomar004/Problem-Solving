public class CheckIfValidPath {
    
}

class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int row=grid.length;
        int col =grid[0].length;
      
        Queue<Pair> q = new LinkedList<>();
        int vis[][]= new int[row][col];
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,+1};

        q.add(new Pair(0,0));
        vis[0][0]=1;
                while(!q.isEmpty())
        {
            Pair p = q.remove();
            int r=p.row;
            int c=p.col;
            vis[r][c]=1;
            if(r==row-1 && c==col-1 )
            {
                return true;
            }
             
             for(int i =0; i<4; i++)
             {
               int newR=r+dr[i];
               int newC=c+dc[i];

               if(newR>=0 && newR<row && newC<col && newC>=0 && vis[newR][newC]==0)
               {  
                check(newR, newC , r,c , grid , vis , q);
                if(vis[newR][newC]==1) return true;
               }
             }
        
        }
         if(vis[row-1][col-1] ==1) return true;
         return false;
        

    }

   void  check(int newR, int newC, int currR ,int currC, int [][]grid , int vis[][] , Queue<Pair> q )
    {
        // check if new cordinates indicates left
         if(newR ==currR && newC==currC-1)
         {

            //For 1
             if( (grid[currR][currC] ==1 || grid[currR][currC] ==3 ||grid[currR][currC] ==5) && (grid[newR][newC] ==1 || grid[newR][newC] ==4 ||  grid[newR][newC] ==6) )
             {   
                if(newR ==grid.length-1 && newC==grid[0].length)
                {
                      vis[newR][newC]=1;
                    return ;
                }
                vis[currR][currC]=1;
                q.add(new Pair(newR,newC));
             }

           else {
            return ;
           }      
       
    
         }

          // Right
         else if(newR ==currR && newC==currC+1)
         {
             if( (grid[currR][currC] ==1 || grid[currR][currC] ==4 ||grid[currR][currC] ==6) && (grid[newR][newC] ==1 || grid[newR][newC] ==3 ||  grid[newR][newC] ==5) )
             {   
                if(newR ==grid.length-1 && newC==grid[0].length)
                {
                      vis[newR][newC]=1;
                    return ;
                }
                vis[currR][currC]=1;
                q.add(new Pair(newR,newC));
             }
             else return;
         }

          // UP
        else if(newR ==currR-1 && newC==currC)
         {
              if( (grid[currR][currC] ==2 || grid[currR][currC] ==5 ||grid[currR][currC] ==6) && (grid[newR][newC] ==2 || grid[newR][newC] ==3 ||  grid[newR][newC] ==4) )
             {   
                if(newR ==grid.length-1 && newC==grid[0].length)
                {
                      vis[newR][newC]=1;
                    return ;
                }
                vis[currR][currC]=1;
                q.add(new Pair(newR,newC));
             }
             else 
             return;
         }

          // check if new cordinates indicates left
        else if(newR ==currR+1 && newC==currC)
         {
              if( (grid[currR][currC] ==2 || grid[currR][currC] ==3 ||grid[currR][currC] ==4) && (grid[newR][newC] ==2 || grid[newR][newC] ==5 ||  grid[newR][newC] ==6) )
             {   
                if(newR ==grid.length-1 && newC==grid[0].length)
                {
                      vis[newR][newC]=1;
                    return ;
                }
                vis[currR][currC]=1;
                q.add(new Pair(newR,newC));
             }
         }
         else {
            return ;
         }
    }
}

class Pair{

    int row; int col;
    Pair(int row, int col)
    {
        this.col=col;
        this.row=row;
    }
}