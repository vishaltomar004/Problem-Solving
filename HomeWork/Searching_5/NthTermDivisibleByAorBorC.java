package HomeWork.Searching_5;

public class NthTermDivisibleByAorBorC {
    
    public static void main(String[] args) 
    { 
        int a = 2, b = 3, c = 5, n = 10; 
 
        System.out.println(NthTerm(a, b, c, n)); 
 
    } 

    static int NthTerm(int a, int b, int c, int n) 
    { 
 
     
        int low = 1, high = Integer.MAX_VALUE, mid; 
 
        while (low < high) { 
            mid = low + (high - low) / 2; 
 
         
            if (divTermCount(a, b, c, mid) < n) 
                low = mid + 1; 
     
        
            else
                high = mid; 
        } 
 
        return low; 
    }
    
    
    static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
         
        return gcd(b % a, a); 
    } 
  
    static int lcm(int a, int b) 
    { 
        return (a * b) / gcd(a, b); 
    } 

    static int divTermCount(int a, int b, int c, int num) 
    { 
 
      
        return ((num / a) + (num / b) + (num / c) 
                - (num / lcm(a, b)) 
                - (num / lcm(b, c)) 
                - (num / lcm(a, c)) 
                + (num / lcm(a, lcm(b, c)))); 
    } 
}
