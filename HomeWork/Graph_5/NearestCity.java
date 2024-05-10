package HomeWork.Graph_5;


public class NearestCity {
    class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adjList= new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int []edge:edges){
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int cityWithMinVCities= 0;
        int minVisited= 200;
        for(int i=0;i<n;i++){
            boolean []visited= new boolean[n];
            PriorityQueue<int[]> citiesList = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
            citiesList.add(new int[]{i, 0});
            
            
            int count=0;
            while(!citiesList.isEmpty()){
                int[] citiesWithWt= citiesList.remove();
                int city= citiesWithWt[0];
                int wt= citiesWithWt[1];
                if(visited[city]==true){
                    continue;
                }
                visited[city]=true;
                count++;
                for(int []vCity: adjList.get(city)){
                    int curCity= vCity[0];
                    int curWt= vCity[1];
                    if(visited[curCity]==false && curWt+wt<=distanceThreshold){
                        citiesList.add(new int[]{curCity, curWt+wt});
                    }
                }
            }
            // System.out.println(count+" n "+minVisited+" minVisited "+i);
            if(minVisited>=count-1){
                minVisited= count-1;
                cityWithMinVCities= i;
            }
        }

        return cityWithMinVCities;
    }
}
}
