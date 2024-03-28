package HomeWork.Tree_1_and_2;

import org.w3c.dom.Node;
class Pair{
    Node node;
    int level;
     public Pair(Node node ,int level)
     {
         this.node=node;
         this.level=level;
     }
}
public class OddEvenInTree {
     int sumOdd=0;
    int sumEven=0;
	int getLevelDiff(Node root)
	{
	    //code here
	    int odd=0;
	    int even=0;
	    help(root , 0 );
	   // System.out.println(sumOdd +"  "+ sumEven);
	    return sumEven-sumOdd;
	}
	
	void help(Node r , int cl) 
	{
	    if(r==null)
	    {
	        return ;
	    }
	    
	    if(cl%2 == 0)
	    {
	        sumEven += r.data;
	    }
	    else 
	    {
	        sumOdd+= r.data;
	    }
	    
	    help(r.left , cl+1 );
	    help(r.right , cl+1 );
	}
}
