
package HomeWork.Graph_2;

/**
 * RottenOranges
 */
public class RottenOranges {

    
}
class Solution {

    public int orangesRotting(int[][] grid) {
        
        int row=grid.length;
        int col = grid[0].length;
int fresh=0;
        int vis[][]= new int[row][col];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i =0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
              if(grid[i][j]==2)
              {
                q.add(new Pair(i ,j ,0));
              
            // System.out.println(i+" "+j+" "+0);
                vis[i][j]=2;
              }  
              else {
                vis[i][j]=0;
              }
              
              if(grid[i][j]==1)
              {
                fresh++;
              }
            }
        }
        //   System.out.println("Pradhan chal raha hai");
          int delR[]={-1,0,1,0};
          int delC[]={0, 1,0,-1};
          int ans=0;
        //   int cnt=0;
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            
            int r=p.row;
            int c=p.col;
            int time=p.time;
            // System.out.println("Curr Pair :"+r+" "+c+" "+time);
            ans=Math.max(ans,time);
            // vis[r][c]=2;
            for(int i =0; i<4; i++)
            {
                int newR=r+delR[i];
                int newC=c+delC[i];

                if(newR>=0 && newR<row && newC >=0 && newC<col && grid[newR][newC] ==1 && vis[newR][newC]==0)
                {   
                    vis[newR][newC]=2;
                    q.add(new Pair(newR,newC,time+1));
                    //  System.out.println("New Pair :"+newR+" "+newC+" "+ (time+1));
                    // cnt++;
                }
            }
        } 
 
        for(int i =0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==1 && vis[i][j] !=2)
                return -1;
            }
        }
        return ans;
    }
}

class Pair{
    int row;
    int col;
    int time;

    Pair(int row, int col, int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}