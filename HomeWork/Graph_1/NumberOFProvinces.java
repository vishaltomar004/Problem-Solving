package HomeWork.Graph_1;

public class NumberOFProvinces {
    public int findCircleNum(int[][] c) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
            int row=c.length;
            int col=c[0].length;
            for(int i =1; i<=row; i++)
            {
                map.put(i , new ArrayList<>());
            }
     for(int i =0; i<row ; i++)
     {
       for(int j =0; j<col ; j++)
       {

        if(c[i][j] ==1 && i!=j)
        {
            map.get(i+1).add(j+1);
        }
       }
     }

     boolean visited[] = new boolean[row+1];
     Arrays.fill(visited , false);
int count=0;
     for(int i =1; i<row+1; i++)
     {
       if(visited[i]==false)
       {
        count++;
        dfs(visited , map ,i);
       } 
     }
        return count;

    }

    void dfs(boolean visited[] , Map<Integer, ArrayList<Integer>> map , int vertex)
    {     
        if(visited[vertex]==true) return ;
         ArrayList<Integer> al = map.get(vertex);
         visited[vertex]=true;
         for(int i =0; i<al.size(); i++)
         {
            if(visited[al.get(i)]==false){
           dfs(visited , map, al.get(i));
            }
         
         }
        
    }
}
