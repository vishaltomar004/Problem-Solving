package HomeWork.Tries_1;

public class SumofPrefixScoresofStrings {
    
}
class Solution {
    Node root = new Node();
    class Node {
        int score =0;
        Node children[] = new Node[26];
    }

    void insert(String s)
    {
        Node temp = root;
        for(char ch :s.toCharArray())
        {
            if(temp.children[ch-'a'] ==null)
              temp.children[ch-'a']=new Node();
            temp.children[ch-'a'].score++;
            temp=temp.children[ch-'a'];  
        }
    }
    public int[] sumPrefixScores(String[] words) {
        // add  each string of word in trie
        for(String word:words) insert(word);

        int res[] = new int[words.length];
        for(int i =0; i<res.length; i++)
        {
            res[i]=calc(words[i]);
        }
        return res;
    }

    int calc(String s)
    {   Node temp = root;
        int ans=0;
        for(char ch: s.toCharArray())
        {
          ans+=temp.children[ch-'a'].score;
          temp = temp.children[ch-'a'];
        }
        return ans;
    }
}